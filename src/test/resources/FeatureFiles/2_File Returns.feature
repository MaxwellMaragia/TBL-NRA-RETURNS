Feature: Lodge Tax Returns

  @file @returns
  Scenario Outline: Verify the process of Submit Tax Return for <ReturnDocument>
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    And Click on return filing and processing > File return
    Then Select return document as "<ReturnDocument>"
    Then Find tax return for tin "<Tin>" with year "<Year>" and number "<Period>"
    Then Fill in file return details for taxtype "<ReturnDocument>"
    Then Submit file return application
    Then Verify success message "Record successfully saved with reference number"
    Then Verify and obtain ARN for file "<Arn>"
    Then go to taxpayer accounting > taxpayer account inquiry
    Then Search for tin "<Tin>"
    Then Search for taxtype "<Taxtype>"
    Then Verify taxtype "<Taxtype>" and status "Posted" is shown in table for "<ReturnDocument>"
    Then Click on case
    Then Verify file returns screen has data for "<ReturnDocument>"
    Examples:
      | ReturnDocument           | Year | Period | Tin        | Arn  | Taxtype                |
      | CIT Return (Provisional) | 2022 | 1      | 1000072665 | CIRP | Company Income Tax     |
#      | CIT Return (Final)       | 2021 | 1      | 1000071839 | CIRT  | Company Income Tax     |
      | Capital Gains Tax Return |      |        | 1000072665 | CGTR | Capital Gains Tax      |
      | PIT Return (Provisional) | 2022 | 1      | 1000072665 | PIRP | Personal Income Tax    |
#      | PIT Return (Final)       | 2021 | 1      | 1000071820 | PIRF  | Personal Income Tax    |
      | Excise Tax Return        | 2021 | 1      | 1000072673 | ETRR | Excise Tax             |
      | FTT Return               | 2021 | 1      | 1000072665 | FTTR | Foreign Travel Tax     |
      | GST Return               | 2021 | 1      | 1000072665 | GSTR | Goods and Services Tax |
#      | PAYE Returns             | 2020 | 9      | 1000071820 | PAYER | Pay As You Earn        |
      | Payroll Tax Return       | 2021 | 1      | 1000072665 | PTRR | Payroll Tax            |
      | Rental income Return     | 2021 | 1      | 1000072665 | RITR | Rental Income Tax      |
      | Withholding Tax          |      |        | 1000072665 | WHT  | Withholding Tax        |