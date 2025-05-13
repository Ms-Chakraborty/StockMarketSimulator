# StockMarketSimulator
A fully console-based stock market simulator written in Java. It uses design principles like MVC and Observer Pattern and is designed to simulate buying/selling stocks, updating stock prices, and tracking gainers/losers.
🚀 Features

👤 Single user portfolio management

📦 Buy and sell stocks

💹 Real-time stock price updates with change tracking

🔔 Observer pattern to notify users of price changes

📊 Displays top gainers and losers based on price change

🛠 Tech Stack

Java 17+

Object-Oriented Programming (OOP)

Design Patterns: MVC, Observer

📁 Project Structure

StockMarketSimulator/
├── Main.java              # Application entry point
├── StockMarket.java       # Subject + Market logic
├── Stock.java             # Stock entity with price tracking
├── User.java              # Observer + portfolio logic
├── Observer.java          # Observer interface
└── Subject.java           # Subject interface

✅ How to Run

Clone or Download the project

Open in any Java IDE or use terminal

**Compile all files:**
javac *.java
java Main
🧪 Sample Flow

===== Stock Market Simulator =====
1. Buy Stock
2. Sell Stock
3. View Portfolio
4. Update Stock Price
5. Exit

Example: Buy AAPL, update its price, and see it appear as a top gainer.

📦 Design Patterns Used

Observer Pattern: User observes StockMarket and gets notified when prices change

MVC:

Model: Stock, User

View: Console output

Controller: Main.java handles flow

🧠 Possible Enhancements

Add multiple users

Export portfolio to CSV

Add persistence (save/load portfolio)

Build GUI (JavaFX / React + Spring Boot)

