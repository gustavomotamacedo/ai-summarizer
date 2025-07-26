import { useEffect, useState } from 'react';
import './App.css'

function App() {
  const [userInput, setUserInput] = useState<string>("");
  const [aiResponse, setAiResponse] = useState<string>("");

  useEffect(() => {
    console.log(aiResponse);
  }, [aiResponse]);

  return (
    <>
      <div className='card'>
        <input type="text" className='text-area' value={userInput} onChange={e => setUserInput(e.target.value)} placeholder='Cole o texto a ser resumido.'/>
        <div>
          <button className='button' onClick={() => {setAiResponse(userInput)}}>Bullet points</button>
          <button className='button' onClick={() => {setAiResponse(userInput)}}>Tweet</button>
        </div>
        <span className='response'>{aiResponse}</span>
      </div>
    </>
  )
}

export default App
