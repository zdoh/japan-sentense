import React, {Component} from 'react';
import axios from "axios";
import {Container} from "react-bootstrap";
import Row from "react-bootstrap/Row";
import Quiz from "../Quiz/Quiz";
import Option from "../../Option/Option";

class StudyWord extends Component {

  state = {
    word: null,
    option: new Option()
  };

  componentDidMount() {
    this.getRandSentence();
  }

  getRandSentence() {
    axios.get('/study/word')
      .then(response => {
        this.setState({
          word: response.data,
          checkAnswer: false
        });

      }).catch(error => {
      console.log(error);
    });
  }

  goodAnswerHandler = () => {
    // todo
    // после добавление пользователей счетчик правильных ответов для предложения для пользователя
    this.getRandSentence();
  };

  badAnswerHandler = () => {
    // todo
    // после добавление пользователей счетчик перавильных ответов для предложения для пользователя
    this.getRandSentence();
  };


  render() {
    let question = null;
    let answer = null;

    if (this.state.word !== null) {
      const word = {...this.state.word};

      question = (
        <div>
          <Row className="justify-content-md-center">{word.wordKanji}</Row>
        </div>
      );

      answer = (
        <Container>
          <Row className="justify-content-md-center">
            {word.pronunciation}
          </Row>
          <Row className="justify-content-md-center">
            {word.translateEntities.filter(w => {
            return w.language.shortName === this.state.option.getLanguage();
            }).map(w => {
              return w.translate;
            })}
          </Row>
        </Container>
      )

    }

    return (
      <Quiz
        question={question}
        answer={answer}
        badAnswerButton={this.badAnswerHandler}
        goodAnswerButton={this.goodAnswerHandler}/>
    )
  }
}


export default StudyWord;