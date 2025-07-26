import { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [userInput, setUserInput] = useState<string>("");
  const [aiResponse, setAiResponse] = useState<string>("");
  const [isLoading, setIsLoading] = useState<boolean>(false);

  useEffect(() => {
    const responseDiv = document.querySelector(".response");
    if (responseDiv) responseDiv.innerHTML = aiResponse;
  }, [aiResponse]);

  const fetchAiResponse = async (input: string, type: string) => {
    const API_BASE_URL = "http://localhost:8081/api/v1";
    const requestBody = {
      summaryType: type,
      text: input,
    };

    setIsLoading(true);

    try {
      const request = new Request(API_BASE_URL.concat("/input"), {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
        body: JSON.stringify(requestBody),
      });

      const response = await fetch(request);

      if (!response.ok) {
        throw new Error(`Response status: ${response.status}`);
      }

      const decoder = new TextDecoder();
      let accumulated = "";

      // eslint-disable-next-line @typescript-eslint/no-explicit-any
      for await (const chunk of response.body as any as AsyncIterable<Uint8Array>) {
        const text = decoder.decode(chunk, { stream: true });
        accumulated += text;
      }

      accumulated += decoder.decode(); // final flush
      accumulated = accumulated.replaceAll("```", "");
      setAiResponse(accumulated);
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    } catch(error) {
      setAiResponse("<strong>Calma ai, a IA cansou.</strong><br/>Mais tarde você volta aqui e ela te responde, ok?");
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <>
      <div className="card">
        <div className="card-header">
          <h1>AI Summarizer</h1>
          <h2>Resuma textos simples utilizando IA generativa.</h2>
          <p>
            Cole seu texto no campo abaixo e selecione o formato de saída
            clicando em um dos botões. Após isso, aguarde seu resumo!
          </p>
        </div>
        <textarea
          className="text-area"
          value={userInput}
          onChange={(e) => setUserInput(e.target.value)}
          placeholder="Cole o texto a ser resumido."
        />
        <div>
          <button
            className="button"
            onClick={() => {
              fetchAiResponse(userInput, "BULLET_POINTS");
            }}
          >
            Bullet points
          </button>
          <button
            className="button"
            onClick={() => {
              fetchAiResponse(userInput, "TWEET");
            }}
          >
            Tweet
          </button>
        </div>
        <div className={`response ${isLoading ? "vibrate-2" : ""}`}>
          {isLoading ? "Gerando seu resumo..." : ""}
        </div>
      </div>
    </>
  );
}

export default App;
