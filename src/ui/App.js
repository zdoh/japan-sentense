import React, {Component} from 'react';
import {BrowserRouter, Route, Switch, withRouter} from 'react-router-dom';
import {connect} from "react-redux";
import * as actions from "./store/actions";
import Words from "./component/Words/Words";
import WordEdit from "./component/Words/WordEdit/WordEdit";
import StudySentence from "./component/Study/StudySentence/StudySentence";
import StudyWord from "./component/Study/StudyWord/StudyWord";
import StudyKanji from "./component/Study/StudyKanji/StudyKanji";
import InProgress from "./component/InProgress/InProgress";
import Navigation from "./component/Navigation/Navigation";
import Login from "./component/User/Login/Login";
import axios from "axios";
import Textbooks from "./component/Textbooks/Textbooks";
import Textbook from "./component/Textbooks/Textbook/Textbook";

axios.defaults.baseURL = 'http://localhost:8080/api';

class App extends Component {


  componentDidMount() {
    this.props.onTryAutoSignup();
  }

  render() {

    return (<BrowserRouter>
        <div className="container">
          <Navigation/>

          <Switch>
            <Route path="/words" component={Words}/>
            <Route path="/word/:id" component={WordEdit}/>
            <Route path="/study/sentence" component={StudySentence}/>
            <Route path="/study/word" component={StudyWord}/>
            <Route path="/study/kanji" component={StudyKanji}/>
            <Route path="/textbooks" component={Textbooks}/>
            <Route path="/textbook/:id" component={Textbook}/>
            <Route path="/kanjis" component={InProgress}/>
            <Route path="/grammars" component={InProgress}/>
            <Route path="/sentences" component={InProgress}/>
            <Route path="/login" component={Login}/>
            <Route path="/" exact component={InProgress}/>
          </Switch>

        </div>
      </BrowserRouter>
    )
  }
}

const mapStateToProps = state => {
  return {
    token: state.token
  }
};

const mapDispatchToProps = dispatch => {
  return {
    onTryAutoSignup: () => dispatch(actions.authCheckState())
  }
};

export default connect(mapStateToProps, mapDispatchToProps)(App);