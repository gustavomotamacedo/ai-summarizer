import { useEffect, useState } from 'react';
import './App.css'

function App() {
  const [userInput, setUserInput] = useState<string>("");
  const [aiResponse, setAiResponse] = useState<string>("");

  useEffect(() => {
    console.log(aiResponse);
  }, [aiResponse]);

  async function streamToText(reader: ReadableStreamDefaultReader<Uint8Array>) {
  const decoder = new TextDecoder();
  let result = "";

  while (true) {
    const { done, value } = await reader.read();
    if (done) break;
    // decodifica o chunk e concatena
    result += decoder.decode(value, { stream: true });
    // aqui você pode, por exemplo, atualizar um estado React:
    // setPartialText(prev => prev + decoder.decode(value, { stream: true }));
  }
  // flush final
  result += decoder.decode();
  return result;
}

  const fetchAiResponse = async (input: string, type: string) => {
    const API_BASE_URL = "http://localhost:8080/api/v1";
    const requestBody = {
      summaryType: type,
      text: input
    }

    const request = new Request(API_BASE_URL.concat("/input"), {
      method: "POST",
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
      },
      body: JSON.stringify(requestBody)
    });

    const response = await fetch(request);

    if (!response.ok) {
      throw new Error(`Response status: ${response.status}`);
    }

    const decoder = new TextDecoder();
    let accumulated = "";

    for await (const chunk of response.body as any as AsyncIterable<Uint8Array>) {
      const text = decoder.decode(chunk, { stream: true });
      accumulated += text;
    }

    accumulated += decoder.decode(); // final flush
    setAiResponse(accumulated);
  }

  return (
    <>
      <div className='card'>
        <input type="text" className='text-area' value={userInput} onChange={(e) => setUserInput(e.target.value)} placeholder='Cole o texto a ser resumido.'/>
        <div>
          <button className='button' onClick={() => {fetchAiResponse(userInput, "BULLET_POINTS")}}>Bullet points</button>
          <button className='button' onClick={() => {fetchAiResponse(userInput, "TWEET")}}>Tweet</button>
        </div>
        <div className='response'>
          {aiResponse}
        </div>
      </div>
    </>
  )
}

export default App
