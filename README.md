# MeroShare
This is a MeroShare automation program coded in Java ( using Eclipse IDE )

Note: Edit the logindetails.java with your MeroShare Credentials
BaseSetup.java uses beforesuite so it will automatically run and doesn't have to be called explicitly

## Features

- Applies for Shares Automatically
- Finds total number of Alloted, Not Alloted and Verfied shares 
- Apply for Shares Automatically
- Finds your Portfolio Total
- Finds your Demat Expiry Date
- Finds your MeroShare Expiry Date
- Finds your Password Expiry Date, Account Created Date, Account Renewed Date

## Each File Functionalities
For one user
- logindetails.java -> Set your login informations here
- BaseSetup.java -> This is chrome driver and login setup ( Uses before Suite so runs automatically for further below files )
- applyshare.java -> Runnable file, This applies for shares whose price is Rs.100 per share and doesn't apply for other shares such as Rs.10 per share or Rs.1000 per share
- ApplicationReport.java -> Runnable file, It checks all the recent applications i.e. applied shares and calculates total number of shares that have been alloted, not alloted and verified shares
- OldReport.java -> Runnable file, Same as ApplicationReport.java but it calculates for older applied shares
- DatesFinder.java -> Runnable File, 
