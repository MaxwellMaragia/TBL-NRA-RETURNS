Feature: Cancel Tax Returns

  @sanity @cancel
  Scenario Outline: Verify the process of Cancel Tax Return for <ReturnDocument>
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    And Click on return filing and processing > Cancel return
    Then Select return document as "<ReturnDocument>"
    Then Find tax return for tin "<Tin>" with year "<Year>" and number "<Period>"
    Then Select reason for cancellation as "RETURN POSTED TO WRONG TAXPAYER" "<ReturnDocument>"
    Then Click cancel return
    Then Click yes
    Then Verify success message "Tax return has successfully saved.The status is now pending cancellation"
    Then Obtain reference number for cancellation "Tax return has successfully saved.The status is now pending cancellation"
    Then Open CRM and close modal
    And Click on Case management dropdown
    And click on Returns Tax return application
    Then switch to frame0
    When enters cancel reference number in search results
    Then Click on reference number
    Then switch to frame1
    And Approve adjust returns application
    Then Click on Returns Save button
    Then switch to frame1
    And Verify approval "Approved"
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