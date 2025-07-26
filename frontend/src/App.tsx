import { useEffect, useState } from 'react';
import './App.css'

function App() {
  const [userInput, setUserInput] = useState<string>("");
  const [aiResponse, setAiResponse] = useState<string>("");

  useEffect(() => {
    console.log(aiResponse);
  }, [aiResponse]);

  const fetchAiResponse = async (input: string) => {
    const API_BASE_URL = "http://localhost:8080/api/v1";
    const bulletPointsBody = {
      summaryType: "BULLET_POINTS",
      text: ""
    }
     const tweetBody = {
      summaryType: "BULLET_POINTS",
      text: ""
    }
    
    switch (key) {
      case value:
        
        break;
    
      default:
        break;
    }

    console.log(API_BASE_URL.concat("/input"));
    console.log(input);
  }

  return (
    <>
      <div className='card'>
        <input type="text" className='text-area' value={userInput} onChange={e => setUserInput(e.target.value)} placeholder='Cole o texto a ser resumido.'/>
        <div>
          <button className='button' onClick={() => {fetchAiResponse(userInput)}}>Bullet points</button>
          <button className='button' onClick={() => {fetchAiResponse(userInput)}}>Tweet</button>
        </div>
        <span className='response'>{aiResponse}</span>
      </div>
    </>
  )
}

export default App
