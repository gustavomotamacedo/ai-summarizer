import './App.css'

function App() {

  return (
    <>
      <div className='card'>
        <input type="text" className='text-area' placeholder='Cole o texto a ser resumido.'/>
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
