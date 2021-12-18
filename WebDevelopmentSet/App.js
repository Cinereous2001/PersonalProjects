import './App.css';
import Navbar from './components/Navbar.js';
import Home from './components/Home';
import AboutView from './components/About';
import { useState, useEffect } from 'react';
import { Routes, Route } from 'react-router-dom'; 
import React from 'react';
import Hero from "./components/Hero";
import SearchView from "./components/SearchView";

function App() {

  const [searchResults, setSearchResults] = useState([]);
  const [searchText, setSearchText] = useState("");

  // console.log(searchText, "is the default");
  // setTimeout( () => {
  //   setSearchText("This text");
  //   console.log(searchText, "is the new text");

  // }, 3000);

  return (
    <div>
      <Navbar searchText = {searchText} setSearchText = {setSearchText}/>
      <Routes>
        <Route path = "/" element = {<Home />} />
        <Route path = '/about' element = {<AboutView/>}/>
        <Route path = "/searchview" element = {<SearchView keyword = {searchText} searchResults = {searchResults}/>}/>
      </Routes>
    </div>
  );
}

export default App;
