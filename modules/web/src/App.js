import './App.css';
import RegistrationForm from "./view/RegistrationForm";
import SuccessUserCreation from "./view/SuccessUserCreation"
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import Home from "./view/Home";

function App() {
  return (
    <div className="App">
      <Router>
        <div className="container">
          <Switch>
              <header className="App-header">
                  <Route path="/" exact component = {Home}></Route>
                  <Route path = "/registration" exact component = {RegistrationForm}></Route>
                  <Route path = "/success" exact component = {SuccessUserCreation} ></Route>
              </header>

          </Switch>
        </div>
      </Router>

    </div>
  );
}

export default App;
