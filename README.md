# ActiveViam_Problem_2

# Assumptions
Historical values across trades will be over the same time period<br/>
Number of stocks owned/trades is set. If user can adjust it will have to generate or calculate random stock values.   
Historical Values are not user input as these values are usually over large sample sizes

# Solution 
Steps I thought of and executed for calculating the Value at Risk for a portfolio

<ol>
 <li>Calculate gains/losses from amount invested in each trade</li>
      <ol>
          <li>Done extracting certain calculations from problem 1 and putting them inside a Stock Object</li>
          <li>Each Stock has a method that calculates the amount of money gained or lost based off of historical value and amount invested</li>
          <li>Above method returns an arraylist of these values. Index in this ArrayList corresponds to historical price index/li>
      </ol>
 <li>Combine gains/losses from each trade and put into an arraylist</li>
 <ol>
    <li>This ArrayList represents the gains and losses of the portfolio</li>
 </ol>
 <li>Get the percentile of the gains and losses of the portfolio based off the confidence value</li>
  <ol>
    <li>Method was used same as problem 1. Nearest rank formula was used. </li>
    <li>This percentile is the Value at Risk for the portfolio</li>
 </ol>
</ol>
