import React, {Component} from 'react';
import { Route, Switch } from 'react-router-dom';
import Layout from "./component/Layout/Layout";
import Words from "./component/Words/Words";
import WordEdit from "./component/Words/WordEdit/WordEdit";
import StudySentence from "./component/Study/StudySentence/StudySentence";
import StudyWord from "./component/Study/StudyWord/StudyWord";
import StudyKanji from "./component/Study/StudyKanji/StudyKanji";
import InProgress from "./component/InProgress/InProgress";

export default class App extends Component {

  render() {
    return (
      <div className="container">
        <Layout>
          <Switch>
            <Route path="/words" component={Words}/>
            <Route path="/word/:id" component={WordEdit}/>
            <Route path="/study/sentence" component={StudySentence}/>
            <Route path="/study/word" component={StudyWord}/>
            <Route path="/study/kanji" component={StudyKanji}/>
            <Route path="/textbooks" component={InProgress}/>
            <Route path="/kanjis" component={InProgress}/>
            <Route path="/grammars" component={InProgress}/>
            <Route path="/sentences" component={InProgress}/>
            <Route path="/" exact component={InProgress}/>
          </Switch>
        </Layout>
      </div>
    )
  }
}