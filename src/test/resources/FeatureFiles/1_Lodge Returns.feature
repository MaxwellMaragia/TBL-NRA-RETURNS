Feature: Lodge Tax Returns

  @SUC:09-01 @UAT_M4-01-01 @sanity @lodge
  Scenario Outline: Verify the process of validation
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    And Click on return filing and processing > Lodge return
    Then Click Return document search button
    Then Search for taxtype with tin "<Tin>" and taxtype "<ReturnDocument>" for period year "<Year>" and number "<Period>"
    Then Submit lodge return application
    Then Verify error message "Liability - Value required."
    Then Enter liability "-9000"
    Then Submit lodge return application
    Then Verify error message "Liability cannot be negative for the selected Return Type"
    Examples:
      | ReturnDocument | Year | Period | Tin        | Arn   | Taxtype         |
      | PAYE Returns   | 2021 | 7      | 1000072665 | PAYER | Pay As You Earn |

  @SUC:09-01 @UAT_M4-01-02 @sanity @lodge
  Scenario Outline: Verify the process of Lodge Paper Return for <ReturnDocument>
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    And Click on return filing and processing > Lodge return
    Then Click Return document search button
    Then Search for taxtype with tin "<Tin>" and taxtype "<ReturnDocument>" for period year "<Year>" and number "<Period>"
    Then Enter liability "9000"
    Then Submit lodge return application
    Then Verify success message "Returns Lodgement is Successful with Reference Number"
    Then Verify late lodgement message for "<ReturnDocument>" with year "<Year>" and period "<Period>"
    Then Verify and obtain ARN "<Arn>"
    Then go to taxpayer accounting > taxpayer account inquiry
    Then Search for tin "<Tin>"
    Then Search for taxtype "<Taxtype>"
    Then Verify taxtype "<Taxtype>" and status "Lodged" is shown in table for "<ReturnDocument>"
    Then Click on case
    Then Verify lodgement screen has data
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

