# Overview
It is a system that allow user to buy, add or edit the item in the system.


## Login

When the system starts, it required user to login.

If it is the first time login, register for a new account is required.

## Register

All registered account will be an User account



# Role
There will be 3 type of role in the system.

- Supplier    : allow to refill the stock in inventory or add new item in inventory

- User        : allow to purchase item in the inventory

- Manager     : allow to manage inventory, order, billing statement and sales report


## Supplier

There is only one account for supplier.

The system allows supplier to refill the stock.

The system allows supplier to add new item to the system.

- email       : supplier@gmail.com

- pw          : iaddstuff

## Manager

There is only one account for manager.

The system allows manager to manage order, manage inventory, manage billing, generate new report and view report.

- email : manager@gmail.com

- pw : igotpower

## User

All registered account later on will be set as User as default.

The system allows user to make order and make payment. 

# Database
All data is saved in .txt file type.


## Billing.txt

Data about the Bill

```[Billing ID], [User Name], [Payment Type], [Amount Paid], [Order ID list]```

- Payment only accept Credit card or Debit card 
- Billing ID will be generated automatically


## Inventory.txt

Data about the inventory

```[Item Name], [Item ID], [Item Price], [Item Weight], [Item Quantity]```

- Besides Item ID, all the attributes is set by the supplier
- Item ID will be generated automatically

## Order.txt

Data about the Order

```[Item Name], [Order ID], [User Name], [Quantity Purchase],[Item Price]```
- Quantity Purchase is determined by the user
- Order ID will be generated automatically

## Report.txt

Data about the Report base on the bill that is completed

```[Report ID], [Amount Paid], [Billing ID list]```
- Amount Paid is depends on the billing in the list
- Report ID will be generated automatically

## User.txt

Data about the User.

```[User Name], [User email], [User Password]```
- Only manager and supllier is hardcoded, the user will be created by the user