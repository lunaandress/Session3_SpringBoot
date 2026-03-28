import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { ProductApp } from './components/ProductApp.jsx'
import './index.css'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <ProductApp />//aqui pongo mi jsx
  </StrictMode>,
)
