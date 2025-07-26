import { useState } from 'react';
import './App.css'

function App() {
  const [userInput, setUserInput] = useState<string>("");

  return (
    <>
      <div className='card'>
        <input type="text" className='text-area' value={userInput} onChange={e => setUserInput(e.target.value)} placeholder='Cole o texto a ser resumido.'/>
        <div>
          <button className='button'>Bullet points</button>
          <button className='button'>Tweet</button>
        </div>
        <span className='response'></span>
      </div>
    </>
  )
}

export default App
