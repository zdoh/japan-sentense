import React, {Component} from 'react';
import axios from "axios";
import Form from "react-bootstrap/Form";
import MySpin from "../../MySpin/MySpin";
import Input from "../../Input/Input";
import Button from "../../Button/Button";
import Option from "../../Option/Option";

class WordEdit extends Component {
  option = new Option();

  state = {
    word: null,
    loaded: false,
  };

  componentDidMount() {
    const {id} = {...this.props.match.params};
    this.getWords(id)
  }

  getWords = (id) => {
    axios.get(`/word/${id}`)
      .then(response => {
        this.setState({
          word: response.data,
          loaded: true
        });

      }).catch(error => {
      console.log(error);
      this.setState({
        loaded: true
      })
    });
  };

  wordChangeHandler = (event) => {
    let word = {...this.state.word};

    if (event.target.name === "translate.ru") {
      word.translateEntities
        .filter(a => {
          return a.language.shortName === this.option.getLanguage()
        })
        .map(a => {
          return a.translate = event.target.value;
        })
    } else {
      word[event.target.name] = event.target.value;
    }

    this.setState({
      word: word
    })
  };

  updateWordHandler = (event) => {
    event.preventDefault();

    axios.post(`/word`, this.state.word)
      .then(
        this.props.history.push("/words")
      ).catch(error => {
      console.log(error);
    });
  };


  render() {
    let result = !this.state.word ? <p>Нет такого слова!!!</p> : <MySpin/>;
    if (this.state.loaded) {
      if (this.state.word) {
        const word = {...this.state.word};
        result = (
          <Form onSubmit={this.updateWordHandler}>
            <Input elementType="input" labelSize="2" colSize="8" label="Слово" name="wordKanji" value={word.wordKanji}
                   change={this.wordChangeHandler} classNames="justify-content-md-center"/>
            <Input elementType="input" labelSize="2" colSize="8" label="Произношение" name="pronunciation"
                   value={word.pronunciation}
                   change={this.wordChangeHandler} classNames="justify-content-md-center"/>
            <Input elementType="input" labelSize="2" colSize="8" label="Перевод"
                   value={word.translateEntities.filter(a => {
                     return a.language.shortName === this.option.getLanguage()
                   }).map(a => {
                     return a.translate
                   })}
                   name="translate.ru" change={this.wordChangeHandler} classNames="justify-content-md-center"/>
            <Button elementType="submitButton" buttonName="Submit" />

          </Form>
        )
      }
    }

    return (
      <div>
        {result}
      </div>
    )
  }
}

export default WordEdit;