# Amazon Automation Task
This is a Java-based web scraper that extracts product information from Amazon search results and adds qualifying products to the cart. The scraper uses the Selenium WebDriver API to automate interactions with the Amazon website.

Getting Started
To use this scraper, you will need to have the following software installed on your system:

Java Development Kit (JDK) version 8 or higher
Selenium WebDriver API for Java
WebDriver executable for your preferred web browser (Chrome, Firefox, etc.)
Usage
To run the scraper, follow these steps:

Clone this repository to your local machine.
Update the driverPath variable in the AmazonScraper.java file with the path to your WebDriver executable.
Update the MAX_PRICE constant in the AmazonScraper.java file with the maximum price for products to be added to the cart.
Run the AmazonScraper.java file.
The scraper will open a new web browser window and navigate to the Amazon home page. It will then prompt you to enter a search query. After entering the query, the scraper will navigate to the search results page and begin scraping product information.

If a product's price is less than or equal to the MAX_PRICE constant, the scraper will click on the "Open product" button and check if an "Add to Cart" button is available. If an "Add to Cart" button is available, the scraper will add the product to the cart and return to the search results page to continue scraping.

After all qualifying products have been added to the cart, the scraper will print the total price of all items in the cart.

Contributing
If you would like to contribute to this project, feel free to submit a pull request or open an issue.

License
This project is licensed under the MIT License - see the LICENSE.md file for details.
