import './App.css';
import PriceListTable from "./view/PriceListTable";
import SuccessUserCreation from "./view/SuccessUserCreation"
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import Home from "./view/Home";
import PriceCalculator from "./view/PriceCalculator";

function App() {
  return (
    <div className="App">
      <Router>
        <div className="container">
          <Switch>
              <header className="App-header">
                  {/*<Route path="/" exact component = {Home}></Route>*/}
                  <Route path = "/" exact component = {PriceListTable}></Route>
                  <Route path = "/price/calculator" exact component = {PriceCalculator} ></Route>
              </header>

          </Switch>
        </div>
      </Router>

    </div>
  );
}

export default App;
