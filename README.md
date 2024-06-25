# Overview
It is a system that allow user to buy, add or edit the item in the system


**Login**

When the system starts, it required user to login

If it is the first time login, register for a new account is required

**Register**

All registered account will be an User account



# Role
There will be 3 type of role in the system

- Supplier    : allow to refill the stock in inventory or add new item in inventory

- User        : allow to purchase item in the inventory

- Manager     : allow to manage inventory, order, billing statement and sales report


**Supplier**

There is only one account for supplier

- email       : supplier@gmail.com

- pw          : igotpower

The system allows supplier to refill the stock

The system allows supplier to add new item to the system


**User**

All registered account later on will 


# Database
All data is saved in .txt file type


**Billing.txt**

Data about the Bill

[Billing ID], [User Name], [Payment Type], [Amount Paid], [Order ID list]


**Inventory.txt**

Data about the inventory

[Item Name], [Item ID], [Item Price], [Item Weight], [Item Quantity]


**Order.txt**

Data about the Order

[Item Name], [Order ID], [User Name], [Quantity Purchase],[Item Price]


**Report.txt**

Data about the Report

[Report ID], [Amount Paid], [Billing ID list]


**User.txt**

Data about the User