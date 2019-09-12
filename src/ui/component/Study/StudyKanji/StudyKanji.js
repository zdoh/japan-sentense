import React, {Component} from 'react';
import Option from "../../Option/Option";
import axios from "axios";
import Row from "react-bootstrap/Row";
import {Container} from "react-bootstrap";
import Quiz from "../Quiz/Quiz";

class StudyKanji extends Component {
  option = new Option();

  state = {
    kanji: null,
  };

  componentDidMount() {
    this.getRandSentence();
  }

  getRandSentence() {
    axios.get('/kanji/random')
      .then(response => {
        this.setState({
          kanji: response.data,
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

    if (this.state.kanji !== null) {
      const kanji = {...this.state.kanji};

      question = (
        <div>
          <Row className="justify-content-md-center">{kanji.kanji}</Row>
        </div>
      );

      answer = (
        <Container>
          <Row className="justify-content-md-center">
            Значение: {kanji.meaning.filter(p => {
              return p.language.shortName === this.option.getLanguage();
            }).map(p => {
              return p.translate;
            })}
          </Row >
          <Row className="justify-content-md-center">
            Онъеми: {kanji.onyumi ? kanji.onyumi.join(" / ") : " - " }
          </Row>
          <Row className="justify-content-md-center">
            Кунъеми: {kanji.kunyumi ? kanji.kunyumi.map(w => {
              const pron = w.pronunciation ? `(${w.pronunciation})` : "";
              return `${w.wordKanji} ${pron}` ;
          }).join(" / ") : " - " }
          </Row>
          <Row className="justify-content-md-center">
            Якорь: {kanji.anchor.wordKanji} ({kanji.anchor.pronunciation}) - {kanji.anchor.translateEntities.filter(w => {
            return w.language.shortName === this.option.getLanguage();
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

export default StudyKanji;