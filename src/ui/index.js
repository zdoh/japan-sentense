import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import axios from 'axios';
import {BrowserRouter} from "react-router-dom";

axios.defaults.baseURL = 'http://localhost:8080/api';

ReactDOM.render(<App/>, document.getElementById('root'));

