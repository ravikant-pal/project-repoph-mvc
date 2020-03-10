package com.alok.repoph.common.utils;

public class Constants {

    private Constants() {
        throw new UnsupportedOperationException();
    }

    public static final String ENGINE_TABLES_ID_REGEX = "^[1-9]{1}[0-9]*$";
    public static final String PROCESS_TASKS_ASSIGNEE_KEY = "assignee";
    public static final String APPLICANT_MOBILE_NUMBER = "applicantMobileNumber";
    public static final String APPLICATION_ID_KEY = "applicationId";
    public static final String CASE_INSTANCE_ID_KEY = "caseInstanceId";
    public static final String CASE_DEFINITION_ID_KEY = "caseDefinitionId";
    public static final String JOURNEY_TYPE = "journeyType";

    /******************* FEC Process Variables And Constants ******************/
    public static final String FEC_REQUESTOR_ID = "ROBO1";
    public static final String FE_CREDIT_DISBURSEMENT_METHOD_KEY = "methodOfDisbursal";

    public static final String FE_CREDIT_BANK_NAME_KEY = "benificiaryBankName";
    public static final String FE_CREDIT_BANK_BRANCH_KEY = "benificiaryBankBranch";
    public static final String FE_CREDIT_ACCOUNT_NUMBER_KEY = "benificiaryAccountNumber";
    public static final String FE_CREDIT_LOAN_AGREEMENT_ID = "loanAgreementId";
    public static final String FE_CREDIT_LOAN_AGREEMENT_UUID = "loanAgreementUUID";
    public static final String FE_CREDIT_LOAN_AGREEMENT_LINK = "loanAgreementLink";
    public static final String FE_CREDIT_CONTRACT_GENERATION_REQUEST_KEY = "feCreditContractGenerationRequest";
    public static final String FE_CREDIT_CONTRACT_GENERATION_RESPONSE_KEY = "feCreditContractGenerationResponse";
    public static final String FE_CREDIT_EMI_SCHEDULE_GENERATION_REQUEST_KEY = "feCreditEMIScheduleGenerationRequest";
    public static final String FE_CREDIT_EMI_SCHEDULE_GENERATION_RESPONSE_KEY = "feCreditEMIScheduleGenerationResponse";

    public static final String FE_CREDIT_REPAYMENT_MORA_REQUEST_KEY = "feCreditRepaymentMoraRequest";
    public static final String FE_CREDIT_REPAYMENT_MORA_RESPONSE_KEY = "feCreditRepaymentMoraResponse";
    public static final String FE_CREDIT_REPAYMENT_MORA_STATUS_KEY = "feCreditRepaymentMoraStatus";
    public static final String FE_CREDIT_REPAYMENT_MORA_INSTALLMENT_ARRAY_KEY = "feCreditRepaymentMoraInstallmentArray";

    public static final String FE_CREDIT_REPAYMENT_NONMORA_REQUEST_KEY = "feCreditRepaymentNonMoraRequest";
    public static final String FE_CREDIT_REPAYMENT_NONMORA_RESPONSE_KEY = "feCreditRepaymentNonMoraResponse";
    public static final String FE_CREDIT_REPAYMENT_NONMORA_STATUS_KEY = "feCreditRepaymentNonMoraStatus";
    public static final String FE_CREDIT_REPAYMENT_NONMORA_INSTALLMENT_ARRAY_KEY = "feCreditRepaymentNonMoraInstallmentArray";

    public static final String FE_CREDIT_REPAYMENT_APS_REQUEST_KEY = "feCreditRepaymentApsRequest";
    public static final String FE_CREDIT_REPAYMENT_APS_RESPONSE_KEY = "feCreditRepaymentApsResponse";
    public static final String FE_CREDIT_REPAYMENT_APS_STATUS_KEY = "feCreditRepaymentApsStatus";
    public static final String FE_CREDIT_REPAYMENT_APS_INSTALLMENT_ARRAY_KEY = "feCreditRepaymentApsInstallmentArray";

    public static final String FE_CREDIT_BIDV_REQUEST_KEY = "feCreditBidvRequest";
    public static final String FE_CREDIT_BIDV_RESPONSE_KEY = "feCreditBidvResponse";
    public static final String FE_CREDIT_BIDV_STATUS_KEY = "feCreditBidvStatus";
    public static final String FE_CREDIT_BIDV_SECURITY_CODE_KEY = "feCreditBidvSecurityCode";

    public static final String BIDV_BANK_CODE = "beneficiaryBankCode";
    public static final String BIDV_BRANCH_CODE = "beneficiaryBranchCode";
    public static final String BIDV_BANK_NAME_CODE = "beneficiaryBankName";
    public static final String BIDV_BANK_ACCOUNT_NUMBER = "beneficiaryAccountNumber";

    public static final String FE_CREDIT_T24_FUND_TRANSFER_REQUEST_KEY = "feCreditT24FundTransferRequest";
    public static final String FE_CREDIT_T24_FUND_TRANSFER_RESPONSE_KEY = "feCreditT24FundTransferResponse";
    public static final String FE_CREDIT_T24_FUND_TRANSFER_ACCOUNT_NUMBER_KEY = "vpBankAccountNumber";
    public static final String FE_CREDIT_T24_FUND_TRANSFER_STATUS_KEY = "feCreditT24FundTransferStatus";
    public static final String FE_CREDIT_T24_FUND_TRANSFER_TRANSACTION_ID_KEY = "feCreditT24FundTransferTransactionId";

    public static final String FE_CREDIT_SCHEME_ID_KEY = "schemeId";
    public static final String FE_CREDIT_SCHEME_DESC_KEY = "schemeDesc";
    public static final String FE_CREDIT_SCHEME_CCY_KEY = "schemeCCY";
    public static final String FE_CREDIT_SCHEME_INT_RATE_KEY = "schemeIntRate";
    public static final String FE_CREDIT_SCHEME_GRPID_KEY = "schemeGRPID";
    public static final String FE_CREDIT_SCHEME_PRODUCT_CODE_KEY = "schemeProductCode";
    public static final String FE_CREDIT_SCHEME_PRODUCT_CATEGORY_KEY = "schemeProductCategory";
    public static final String FE_CREDIT_SCHEME_MIN_TENOR_KEY = "schemeMinTenor";
    public static final String FE_CREDIT_SCHEME_MAX_TENOR_KEY = "schemeMaxTenor";
    public static final String FE_CREDIT_SCHEME_MIN_AMT_KEY = "schemeMinAmt";
    public static final String FE_CREDIT_SCHEME_MAX_AMT_KEY = "schemeMaxAmt";
    public static final String FE_CREDIT_SCHEME_MIN_DOWN_KEY = "schemeMinDown";
    public static final String FE_CREDIT_SCHEME_MAX_DOWN_KEY = "schemeMaxDown";
    public static final String FE_CREDIT_SCHEME_MULTI_RATE_FLG_KEY = "schemeMultiRateFlag";
    public static final String FE_CREDIT_SCHEME_PRODUCT_FLG_KEY = "schemeProductFlag";
    public static final String FE_CREDIT_SCHEME_DETAIL_NAME_KEY = "schemeDetailName";

    public static final String DISBURSEMENT_CHANNEL_REGEX = "^(AT)|(BI)|(AG)|(SA)|(VN)$";
    public static final String DISBURSEMENT_STATUS_CODE = "^(A)|(C)|(F)$";
    public static final String DISBURSEMENT_DATE = "^[0-9]{8}$";
    public static final String APPLICATION_ID_REGEX = "^[0-9]+$";

    public static final String FE_CREDIT_DISBURSEMENT_STATUS_KEY = "disbursementStatus";
    public static final String FE_CREDIT_DISBURSEMENT_COUNT_KEY = "disbursementCount";
    public static final String FE_CREDIT_NO_DISBURSEMENT_TASK_MESSAGE = "No task in disbursement stage for given Assignee and Application Id";
    public static final String FE_CREDIT_NO_TASK_MESSAGE = "No task for given Assignee and Application Id";
    public static final String FE_CREDIT_APPLICATION_DISBURSED_KEY = "disbursed";
    public static final String FE_CREDIT_APPLICATION_APPROVED_KEY = "approved";

    public static final String REPAYMENT_SCHEDULE_DOCUMENT_ID = "repaymentScheduleDocumentId";

    public static final String FE_CREDIT_MVP_SMS_MOBILE_KEY = "mobile";
    public static final String FE_CREDIT_MVP_SMS_MESSAGE_KEY = "message";
    public static final String FE_CREDIT_MVP_SMS_REQUEST_KEY = "feCreditmvpSMSRequest";
    public static final String FE_CREDIT_MVP_SMS_RESPONSE_KEY = "feCreditmvpSMSResponse";
    public static final String FE_CREDIT_MVP_SMS_STATUS_KEY = "feCreditmvpSMSStatusKey";

    public static final String FE_CREDIT_LOAN_APPROVAL_SMS_REQUEST_KEY = "feCreditLoanApprovalSMSRequest";
    public static final String FE_CREDIT_LOAN_APPROVAL_SMS_RESPONSE_KEY = "feCreditLoanApprovalSMSResponse";

    public static final String FE_CREDIT_LOAN_AGREEMENT_EMAIL_REQUEST_KEY = "feCreditLoanAgreementEmailRequest";
    public static final String FE_CREDIT_LOAN_AGREEMENT_EMAIL_RESPONSE_KEY = "feCreditLoanAgreementEmailResponse";

    public static final String FE_CREDIT_LOAN_DISBURSED_EMAIL_REQUEST_KEY = "feCreditLoanDisbursedEmailRequest";
    public static final String FE_CREDIT_LOAN_DISBURED_EMAIL_RESPONSE_KEY = "feCreditLoanDisbursedEmailResponse";

    public static final String FE_CREDIT_VN_POST_CODE_SMS_REQUEST_KEY = "feCreditVNPostCodeSMSRequest";
    public static final String FE_CREDIT_VN_POST_CODE_SMS_RESPONSE_KEY = "feCreditVNPostCodeSMSResponse";

    public static final String FE_CREDIT_VN_POST_CODE_EXPIRED_SMS_REQUEST_KEY = "feCreditVNPostCodeExpiredSMSRequest";
    public static final String FE_CREDIT_VN_POST_CODE_EXPIRED_SMS_RESPONSE_KEY = "feCreditVNPostCodeExpiredSMSResponse";

    public static final String FE_CREDIT_VN_POST_DISBURSAL_SUCCESSFUL_SMS_REQUEST_KEY = "feCreditVNPostCodeDisbursalSuccessfulSMSRequest";
    public static final String FE_CREDIT_VN_POST_DISBURSAL_SUCCESSFUL_SMS_RESPONSE_KEY = "feCreditVNPostCodeDisbursalSuccessfulSMSResponse";

    public static final String FE_CREDIT_MVP_PCB_STATUS_KEY = "feCreditmvpPCBStatus";
    public static final String FE_CREDIT_MVP_PCB_API_REQUEST_KEY = "feCreditmvpPCBAPIRequest";
    public static final String FE_CREDIT_MVP_PCB_API_RESPONSE_KEY = "feCreditmvpPCBAPIResponse";
    public static final String FE_CREDIT_MVP_PCB_MONTHLY_INSTALMENT_KEY = "feMonthlyInstalments";
    public static final String FE_CREDIT_MVP_PCB_CREDIT_LIMIT_KEY = "feCreditLimit";
    public static final String FE_CREDIT_MVP_PCB_OVER_DRAFT_KEY = "feOverDraft";
    public static final String FE_CREDIT_MVP_PCB_LIMIT_OF_CREDIT_KEY = "feLimitOfCredit";
    public static final String FE_CREDIT_MVP_PCB_WORST_RECENT_STATUS_KEY = "feWorstRecentStatus";
    public static final String FE_CREDIT_BORROWER_FULL_NAME_FROM_PCB_KEY = "fullNameFromPCB";

    public static final String FE_CREDIT_MVP_FROM_EMAIL_KEY = "emailFrom";
    public static final String FE_CREDIT_MVP_SUBJECT_EMAIL_KEY = "emailSubject";
    public static final String FE_CREDIT_MVP_MESSAGE_EMAIL_KEY = "emailMessage";
    public static final String FE_CREDIT_MVP_EMAIL_RESPONSE_KEY = "FECreditEmailResponse";
    public static final String FE_CREDIT_MVP_EMAIL_STATUS_KEY = "FECreditEmailStatus";

    public static final String CUSTOMER_ID_GENERATION_API_REQUEST_KEY = "customerIdGenerationAPIRequest";
    public static final String CUSTOMER_ID_GENERATION_API_RESPONSE_KEY = "customerIdGenerationAPIResponse";
    public static final String CUSTOMER_ID_KEY = "customerId";

    public static final String APPLICATION_ID_GENERATION_API_REQUEST_KEY = "applicationIdGenerationAPIRequest";
    public static final String APPLICATION_ID_GENERATION_API_RESPONSE_KEY = "applicationIdGenerationAPIResponse";

    public static final String CONTRACT_ID_GENERATION_API_REQUEST_KEY = "contractIdGenerationAPIRequest";
    public static final String CONTRACT_ID_GENERATION_API_RESPONSE_KEY = "contractIdGenerationAPIResponse";
    public static final String CONTRACT_ID_KEY = "contractId";

    public static final String VMG_API_REQUEST_KEY = "vmgAPIRequest";
    public static final String VMG_API_RESPONSE_KEY = "vmgAPIResponse";
    public static final String VMG_API_STATUS_KEY = "vmgAPIStatus";
    public static final String VMG_API_LATEST_INCOME_TOTAL_KEY = "vmgAPILatestIncomeTotal";
    public static final String VMG_API_LATEST_MONTHLY_INCOME_KEY = "vmgAPILatestMonthlyIncomeKey";
    public static final String VMG_API_LATEST_INCOME_YEAR_KEY = "vmgAPILatestIncomeYear";
    public static final String VMG_API_LATEST_JOB_YEAR_KEY = "vmgAPILatestJobYear";
    public static final String VMG_API_LATEST_INCOME_KEY = "vmgAPILatestIncome";
    public static final String VMG_API_LATEST_JOB_KEY = "vmgAPILatestJob";
    public static final String INCOME_BASED_FOIR = "incomeBaseFOIR";
    public static final String INSURANCE_PERCENTAGE_BASED_ON_COMPANY_CATEGORY = "insurancePercentage";

    public static final String VN_POST_API_REQUEST_KEY = "vnPostAPIRequest";
    public static final String VN_POST_API_RESPONSE_KEY = "vnPostAPIResponse";
    public static final String VN_POST_CODE_KEY = "vnPostCode";

    public static final String FE_CREDIT_FINAL_EMI_KEY = "finalCalculatedEMI";
    public static final String FINAL_EMI_KEY = "finalCalculatedEMI";

    public static final String LEAD_DB_TRUSTING_SOCIAL_API_REQUEST_KEY = "leadDBTrustingSocialAPIRequest";
    public static final String LEAD_DB_TRUSTING_SOCIAL_API_RESPONSE_KEY = "leadDBTrustingSocialAPIResponse";

    public static final String FE_CREDIT_GCL_TOTAL_CONSUMED_API_REQUEST_KEY = "gclTotalConsumedAPIRequest";
    public static final String FE_CREDIT_GCL_TOTAL_CONSUMED_API_RESPONSE_KEY = "gclTotalConsumedAPIResponse";
    public static final String FE_CREDIT_TOTAL_AVAILABLE_CREDIT_AMOUNT_KEY = "gclTotalAvailableCreditAmount";

    public static final String FE_CREDIT_TOTAL_CONSUMED_PEGA_API_REQUEST_KEY = "gclTotalConsumedPegaAPIRequest";
    public static final String FE_CREDIT_TOTAL_CONSUMED_PEGA_API_RESPONSE_KEY = "gclTotalConsumedPegaAPIResponse";
    public static final String FE_CREDIT_TOTAL_CONSUMED_AMOUNT_PEGA_KEY = "gclTotalConsumedAmountPega";
    public static final String FE_CREDIT_TOTAL_CONSUMED_NO_OF_APPLICATIONS_PEGA_KEY = "gclTotalConsumedPegaNoOfApplications";
    public static final String FE_CREDIT_TOTAL_CONSUMED_TOTAL_EMI_PEGA_KEY = "gclTotalConsumedPegaTotalEmi";

    public static final String FE_CREDIT_TOTAL_CONSUMED_F1CAS_API_REQUEST_KEY = "gclTotalConsumedF1CASAPIRequest";
    public static final String FE_CREDIT_TOTAL_CONSUMED_F1CAS_API_RESPONSE_KEY = "gclTotalConsumedF1CASAPIResponse";
    public static final String FE_CREDIT_TOTAL_CONSUMED_AMOUNT_F1CAS_KEY = "gclTotalConsumedAmountF1CAS";
    public static final String FE_CREDIT_TOTAL_CONSUMED_NO_OF_APPLICATIONS_F1CAS_KEY = "gclTotalConsumedF1CASNoOfApplications";
    public static final String FE_CREDIT_TOTAL_CONSUMED_TOTAL_EMI_F1CAS_KEY = "gclTotalConsumedF1CASTotalEmi";

    public static final String FE_CREDIT_TOTAL_CONSUMED_ACCTDB_API_REQUEST_KEY = "gclTotalConsumedACCTDBAPIRequest";
    public static final String FE_CREDIT_TOTAL_CONSUMED_ACCTDB_API_RESPONSE_KEY = "gclTotalConsumedACCTDBAPIResponse";
    public static final String FE_CREDIT_TOTAL_CONSUMED_AMOUNT_ACCTDB_KEY = "gclTotalConsumedAmountACCTDB";
    public static final String FE_CREDIT_TOTAL_CONSUMED_NO_OF_APPLICATIONS_ACCTDB_KEY = "gclTotalConsumedACCTDBNoOfApplications";
    public static final String FE_CREDIT_TOTAL_CONSUMED_TOTAL_EMI_ACCTDB_KEY = "gclTotalConsumedACCTDBTotalEmi";

    public static final String FE_CREDIT_DOCUSIGN_URL_KEY = "esignLoanAgreement";
    public static final String FE_CREDIT_DOCUSIGN_API_REQUEST_KEY = "feCreditDocusignAPIRequest";
    public static final String FE_CREDIT_DOCUSIGN_API_RESPONSE_KEY = "feCreditDocusignAPIResponse";

    public static final String PLACE_OF_ISSUE_OF_NATIONAL_ID_FROM_HYPERVERGE_KEY = "placeOfIssue";
    public static final String NATIONAL_ID_FROM_HYPERVERGE_KEY = "nationalIdFromHyperverge";
    public static final String BORROWER_FULL_NAME_FROM_HYPERVERGE_KEY = "borrowerFullNameFromHyperverge";
    public static final String DATE_OF_ISSUE_FROM_HYPERVERGE_KEY = "dateOfIssuefromHyperverge";
    public static final String DATE_OF_BIRTH_FROM_HYPERVERGE_KEY = "dateOfBirthFromHyperverge";
    public static final String PROVINCE_FROM_HYPERVERGE_KEY = "provinceFromHyperverge";
    public static final String PROVINCE_CODE_FROM_HYPERVERGE_CITY = "provinceCodeFromHypervergeCity";
    public static final String VIETNAM_NATIONAL_ID_FRONT_URI = "vietnamNationalIdUri";

    public static final String HYPERVERGE_DATA_COMPLETE_STATUS_FLAG = "hypervergeDataCompleteStatus";
    public static final String REJECT_LOAN_APPLICATION_FLAG = "rejectLoanApplication";
    public static final String REJECT_LOAN_APPLICATION_MESSAGE = "rejectLoanApplicationMessage";
    public static final String REPAYMENT_SCHEDULE_LINK_KEY = "repaymentSchedule";

    public static final String RETRY_HYPERVERGE_COUNT = "retryHypervergeCount";
    public static final String RETRY_HYPERVERGE_FLAG = "retryHyperverge";
    public static final String HARD_REJECT_FLAG = "hardReject";
    public static final String RETRY_SELFIE_COUNT = "selfieRetryCount";
    public static final String RETRY_SELFIE_FLAG = "selfieRetry";
    public static final String RETRY_HYPERVERGE_REASON = "retryHypervergeReason";

    public static final String APPLICANT_AGE = "applicantAge";

    public static final String TEMPORARY_ADDRESS_LINE_1_KEY = "temporaryAddressLine1";
    public static final String TEMPORARY_ADDRESS_LINE_2_KEY = "temporaryAddressLine2";
    public static final String TEMPORARY_PROVINCE_KEY = "temporaryProvince";
    public static final String TEMPORARY_WARD_KEY = "temporaryWard";
    public static final String TEMPORARY_STREET_KEY = "temporaryStreet";
    public static final String TEMPORARY_CITY_DISTRICT_KEY = "temporaryCityDistrict";
    public static final String TEMPORARY_PROVINCE_CODE = "temporaryProvinceCode";
    public static final String TEMPORARY_CITY_DISTRICT_CODE = "temporaryCityDistrictCode";
    public static final String TEMPORARY_WARD_CODE = "temporaryWardCode";
    public static final String TEMPORARY_COUNTRY_CODE = "temporaryCountryCode";
    public static final String TEMPORARY_ADDRESS_VALID_FROM = "temporaryAddressValidFrom";

    public static final String PERMANENT_ADDRESS_LINE_1_KEY = "permanentAddressLine1";
    public static final String PERMANENT_ADDRESS_LINE_2_KEY = "permanentAddressLine2";
    public static final String PERMANENT_PROVINCE_KEY = "permanentProvince";
    public static final String PERMANENT_WARD_KEY = "permanentWard";
    public static final String PERMANENT_STREET_KEY = "permanentStreet";
    public static final String PERMANENT_CITY_DISTRICT_KEY = "permanentCityDistrict";
    public static final String PERMANENT_PROVINCE_CODE = "permanentProvinceCode";
    public static final String PERMANENT_CITY_DISTRICT_CODE = "permanentCityDistrictCode";
    public static final String PERMANENT_WARD_CODE = "permanentWardCode";
    public static final String PERMANENT_COUNTRY_CODE = "permanentCountryCode";
    public static final String PERMANENT_ADDRESS_VALID_FROM = "permanentAddressValidFrom";

    public static final String TEMPORARY_ADDRESS_SAME_AS_PERMANENT_ADDRESS_KEY = "isTemporaryAddressSameAsPermanentAddress";

    public static final String BLACKLIST_API_REQUEST_KEY = "blacklistAPIRequest";
    public static final String BLACKLIST_API_RESPONSE_KEY = "blacklistAPIResponse";
    public static final String BLACKLIST_STATUS_KEY = "blacklistStatus";

    public static final String CIF_API_REQUEST_KEY = "cifAPIRequest";
    public static final String CIF_API_RESPONSE_KEY = "cifAPIResponse";

    public static final String CIF_BASIC_INFO_API_REQUEST_KEY = "cifBasicInfoAPIRequest";
    public static final String CIF_BASIC_INFO_API_RESPONSE_KEY = "cifBasicInfoAPIResponse";

    public static final String CIF_ADDRESS_LIST_API_REQUEST_KEY = "cifAddressListAPIRequest";
    public static final String CIF_ADDRESS_LIST_API_RESPONSE_KEY = "cifAddressListAPIResponse";

    public static final String CIF_STATUS_KEY = "cifStatusKey";
    public static final String CIF_NUMBER_KEY = "cifNumberKey";
    public static final String CIF_FULL_NAME_KEY = "cifFullNameKey";
    public static final String CIF_DATE_OF_BIRTH_KEY = "cifDateOfBirthKey";
    public static final String CIF_NATIONAL_ID_KEY = "cifNationalIdKey";
    public static final String CIF_ADDRESS_LINE_1_KEY = "cifAddressLine1Key";
    public static final String CIF_ADDRESS_LINE_2_KEY = "cifAddressLine2Key";
    public static final String CIF_WARD_KEY = "cifWardKey";
    public static final String CIF_CITY_KEY = "cifCityKey";
    public static final String CIF_PROVINCE_KEY = "cifProvinceKey";

    public static final String CIF_BASIC_INFO_STATUS_KEY = "cifBasicInfoStatusKey";
    public static final String CIF_FIRST_NAME_KEY = "cifFirstNameKey";
    public static final String CIF_MIDDLE_NAME_KEY = "cifMiddleNameKey";
    public static final String CIF_LAST_NAME_KEY = "cifLastNameKey";
    public static final String CIF_TITLE_KEY = "cifTitleKey";
    public static final String CIF_MARITAL_STATUS_KEY = "cifMaritalStatusKey";
    public static final String CIF_SHORT_NAME_KEY = "cifShortNameKey";

    public static final String CIF_ADDRESS_LIST_STATUS_KEY = "cifAddressListStatusKey";

    public static final String CIF_CURRENT_ORGANIZATION_KEY = "cifCurrentOrganizationKey";

    public static final String FINAL_LOAN_AMOUNT_APPROVED = "finalLoanAmountApproved";
    public static final String FINAL_LOAN_AMOUNT_TO_DISBURSE_KEY = "finalLoanAmountToDisburse";
    public static final String FINAL_LOAN_AMOUNT_TO_DISBURSE_IN_VN_FORMAT_KEY = "finalLoanAmountToDisburseInVNFormat";
    // public static final String FINAL_LOAN_EMI = "finalLoanEmi";
    public static final String FINAL_LOAN_TENURE = "finalLoanTenure";

    public static final String ACCOUNT_OPEN_DATE = "accountOpenDate";

    public static final String APPLICATION_START_DATE = "applicationStartDate";

    public static final String LMS_API_REQUEST_KEY = "lmsAPIRequest";
    public static final String LMS_API_RESPONSE_KEY = "lmsAPIResponse";

    public static final String HYPERVERGE_NATIONAL_ID_FRONT_API_RESPONSE_KEY = "hypervergeNationalIdFrontAPIResponse";
    public static final String HYPERVERGE_NATIONAL_ID_BACK_API_RESPONSE_KEY = "hypervergeNationalIdBackAPIResponse";
    public static final String HYPERVERGE_FACE_MATCH_API_RESPONSE_KEY = "hypervergeFaceMatchAPIResponse";
    public static final String HYPERVERGE_FACE_MATCH_STATUS_KEY = "hypervergeFaceMatchStatus";
    public static final String SELFIE_MATCH_FLAG = "selfieMatchFlag";
    public static final String SELFIE_MATCH_SCORE = "selfieMatchScore";

    public static final String FINAL_LOAN_AMOUNT_REQUESTED = "finalLoanAmountRequsted";
    public static final String INSURANCE_AMOUNT_ON_LOAN_REQUESTED = "insuranceAmountOnLoanRequested";
    public static final String BORROWER_AGE_KEY = "age";
    public static final String NATIONAL_ID_KEY = "nationalId";
    public static final String DATE_OF_BIRTH_KEY = "dateOfBirth";
    public static final String FB_NUMBER_KEY = "fbNumber";
    public static final String PERSON_TYPE_KEY = "personType";
    public static final String MOBILE_NUMBER_KEY = "mobileNumber";
    public static final String CREDIT_CARD_NUMBER_KEY = "creditCardNUmber";
    public static final String ACCOUNT_NUMBER_KEY = "accountNumber";
    public static final String CONTRACT_NUMBER_KEY = "contractNumber";
    public static final String BORROWER_FULL_NAME_KEY = "borrowerFullName";
    public static final String MARITAL_STATUS_KEY = "maritalStatus";
    public static final String COMPANY_TITLE_KEY = "companyTitle";
    public static final String COMPANY_NAME_KEY = "companyName";
    public static final String COMPANY_CATEGORY_KEY = "companyCategory";
    public static final String COMPANY_ADDRESS_KEY = "companyAddress";
    public static final String COMPANY_TYPE_KEY = "companyType";
    public static final String USER_SALARY_DATE_KEY = "salaryDate";
    public static final String EMI_START_DATE_KEY = "emiStartDate";
    public static final String DESIGNATION_KEY = "designation";
    public static final String SALARY_DATE_KEY = "salaryDate";
    public static final String LOS_APPLICATION_ID_KEY = "losApplicationId";

    public static final String TENURE_KEY = "loanTenure";
    public static final String LOAN_EMI_KEY = "emi";
    public static final String LOAN_INCLUDE_INSURANCE_KEY = "includeLoanInsurance";
    public static final String OCCUPATION_KEY = "occupation";
    public static final String INSURANCE_AMOUNT_KEY = "insuranceAmount";
    public static final String INSURANCE_COMPANY_CODE = "insuranceCompanyCode";

    public static final String CREDIT_ASSESSMENT_2_REQUEST_KEY = "creditAssessment2Request";
    public static final String CREDIT_ASSESSMENT_2_RESPONSE_KEY = "creditAssessment2Response";

    public static final String CREDIT_ASSESSMENT_1_REQUEST_KEY = "creditAssessment1Request";
    public static final String CREDIT_ASSESSMENT_1_RESPONSE_KEY = "creditAssessment1Response";

    public static final String NATIONALITY_KEY = "nationality";

    public static final String MOBILE_NUMBER_REGEX = "^(\\+91)?[789]{1}[0-9]{9}$";
    public static final String PIN_CODE_REGEX = "^[1-9]{1}[0-9]{5}$";
    public static final String EMPTY_OR_NUMBER_REGEX = "(^$)|(^[0-9]+$)";
    public static final String NOT_ZERO_NUMBER_REGEX = "^[1-9]{1}[0-9]*$";
    public static final String DECIMAL_NUMBER_REGEX = "^[0-9]+(\\.)?[0-9]+";
    public static final String COMMENT_TYPE_REGEX = "^(fi)|(legal)|(valuation)|(main)$";
    public static final String IFSC_CODE_REGEX = "^[A-Za-z]{4}[0-9]{7}";
    public static final String PAN_REGEX = "^[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}$";
    public static final String AADHAAR_REGEX = "^[0-9]{12}$";
    public static final String OWNERSHIP_OF_RESIDENCE_REGEX = "";
    public static final String TYPE_OF_RESIDENCE_REGEX = "";
    public static final String NATURE_OF_BUSINESS_REGEX = "";
    public static final String TYPE_OF_BUSINESS_REGEX = "";
    public static final String SWAKARMA_JOURNEY_NAME_REGEX = "^(swakarmaMSME)|(swakarmaSupplyChainSales)|(SwakarmaCoLending)$";
    public static final String DOCUMENT_TAG_REGEX = "^(pan)|(aadhaar)|(bankStatement)|(fiIdentityProof)|"
            + "(fiAddressProof)|(fiIncomeProof)|(fiEmploymentProof)|(assessment)|"
            + "(fiEMandate)|(generatedSanctionLetter)|(acceptedSanctionLetter)"
            + "|(legalReport)|(valuationReport)|(fiAdditionalDocuments)"
            + "|(businessIdDocuments)|(businessBillDocuments)|(businessFinanceDocuments)"
            + "|(drfDocuments)|(csfDocuments)|(pdcDocuments)" + "|(insuranceDocuments)|(nachDocuments)|(otherDocuments)"
            + "|(identityProof)|(addressProof)|(employmentProof)|(incomeProof)|(repaymentSchedule)$";
    public static final String SALES_AGENT_ID_KEY = "salesAgentId";
    public static final String CUSTOMER_NAME_KEY = "customerName";
    public static final String PRODUCT_TYPE_KEY = "productType";
    public static final String LOAN_AMOUNT_KEY = "loanAmount";
    public static final String LOAN_APPLICATION_ID_KEY = "applicationId";
    public static final String INITIATOR_KEY = "initiator";
    public static final String PROCESS_STATUS_KEY = "leadStatus";
    public static final String START_TIME_KEY = "startTime";
    public static final String MOBILE_KEY = "mobile";
    public static final String LEAD_PIN_CODE_KEY = "leadPINCode";
    public static final String BC_IDENTIFIER_KEY = "bcIdentifier";

    public static final String MONTHLY_INCOME_KEY = "monthlyIncome";
    public static final String OTHER_EMI_KEY = "otherEMIs";
    public static final String PROPERTY_TYPE_KEY = "propertyType";
    public static final String PROPERTY_LOCATION_KEY = "propertyLocation";
    public static final String COMPLETED_TASK_KEY = "completedProcessTasks";
    public static final String RATE_OF_INTEREST_KEY = "roi";

    public static final String BUSINESS_TYPE_KEY = "businessType";
    public static final String LEAD_CURRENT_ADDRESS_KEY = "leadCurrentAddress";
    public static final String LEAD_SOURCE_KEY = "leadSource";
    public static final String SALES_APPOINTMENT_HISTORY_KEY = "salesAppointmentHistory";
    public static final String CA_APPOINTMENT_HISTORY_KEY = "caAppointmentHistory";
    public static final String OPS_APPOINTMENT_HISTORY_KEY = "opsAppointmentHistory";
    public static final String APPOINTMENT_HISTORY_KEY_SUFFIX = "AppointmentHistory";

    public static final String CURRENT_RESIDENCE_ADDRESS_KEY = "currentResidenceAddress";
    public static final String CURRENT_RESIDENCE_CITY_KEY = "currentResidenceCity";
    public static final String CURRENT_RESIDENCE_STATE_KEY = "currentResidenceState";
    public static final String CURRENT_RESIDENCE_PIN_CODE_KEY = "currentResidencePINCode";
    public static final String PERMANENT_RESIDENCE_ADDRESS_KEY = "permanentResidenceAddress";
    public static final String PERMANENT_RESIDENCE_CITY_KEY = "permanentResidenceCity";
    public static final String PERMANENT_RESIDENCE_STATE_KEY = "permanentResidenceState";
    public static final String PERMANENT_RESIDENCE_PIN_CODE_KEY = "permanentResidencePINCode";
    public static final String OWNERSHIP_OF_RESIDENCE_KEY = "ownershipOfResidence";
    public static final String TYPE_OF_RESIDENCE_KEY = "typeOfResidence";
    public static final String LANDLINE_KEY = "landline";
    public static final String OFFICE_TELEPHONE_KEY = "officeTelephoneNumber";
    public static final String NATURE_OF_BUSINESS_KEY = "natureOfBusiness";
    public static final String OFFICE_ADDRESS_KEY = "officeAddress";
    public static final String OFFICE_CITY_KEY = "officeCity";
    public static final String OFFICE_STATE_KEY = "officeState";
    public static final String OFFICE_PIN_CODE_KEY = "officePINCode";
    public static final String ANNUAL_TUNROVER_KEY = "annualTurnover";
    public static final String NAME_OF_ECOSYSTEM_PARTNER_KEY = "nameOfEcoSystemPartner";
    public static final String NAME_OF_FIELD_EXECUTIVE_KEY = "nameOfFieldExecutive";
    public static final String BRANCH_NAME_KEY = "branchName";
    public static final String OFFICE_BRANCH_ADDRESS_1_KEY = "officeBranchAddress1";
    public static final String OFFICE_BRANCH_CITY_1_KEY = "officeBranchCity1";
    public static final String OFFICE_BRANCH_STATE_1_KEY = "officeBranchState1";
    public static final String OFFICE_BRANCH_PIN_CODE_1_KEY = "officeBranchPINCode1";
    public static final String OFFICE_BRANCH_ADDRESS_2_KEY = "officeBranchAddress2";
    public static final String OFFICE_BRANCH_CITY_2_KEY = "officeBranchCity2";
    public static final String OFFICE_BRANCH_STATE_2_KEY = "officeBranchState2";
    public static final String OFFICE_BRANCH_PIN_CODE_2_KEY = "officeBranchPINCode2";

    public static final String PAN_KEY = "pan";
    public static final String FIRST_NAME_KEY = "firstName";
    public static final String MIDDLE_NAME_KEY = "middleName";
    public static final String LAST_NAME_KEY = "lastName";
    public static final String GENDER_KEY = "gender";
    public static final String EMAIL_ID_KEY = "emailId";
    public static final String CIBIL_PERMISSION_KEY = "cibilPermission";
    public static final String PAN_VERIFIED_KEY = "panVerified";
    public static final String PAN_DOCUMENT_KEY = "panDocumentKey";

    public static final String AADHAAR_KEY = "aadhaar";
    public static final String AADHAAR_ADDRESS_LINE_1_KEY = "aadhaarAddressLine1";
    public static final String AADHAAR_ADDRESS_LINE_2_KEY = "aadhaarAddressLine2";
    public static final String AADHAAR_PIN_CODE_KEY = "aadhaarPINCode";
    public static final String AADHAAR_CITY_KEY = "aadhaarCity";
    public static final String AADHAAR_STATE_KEY = "aadhaarState";
    public static final String CORRESPONDENCE_SAME_KEY = "correspondenceAddressSame";
    public static final String AADHAAR_GEOTAGGING_KEY = "aadhaarGeoTagging";
    public static final String AADHAAR_VERIFIED_KEY = "aadhaarVerified";
    public static final String AADHAAR_VERIFICATION_OTP_KEY = "aadhaarVerificationOTP";
    public static final String AADHAAR_DOCUMENT_KEY = "aadhaarDocumentKey";

    public static final String BUILDING_NAME_KEY = "buildingName";
    public static final String CORRESPONDENCE_ADDRESS_LINE_1_KEY = "correspondenceAddressLine1";
    public static final String CORRESPONDENCE_ADDRESS_LINE_2_KEY = "correspondenceAddressLine2";
    public static final String CORRESPONDENCE_LANDMARK_KEY = "correspondenceAddressLandmark";
    public static final String CORRESPONDENCE_PIN_CODE_KEY = "correspondencePINCode";
    public static final String CORRESPONDENCE_CITY_KEY = "correspondenceCity";
    public static final String CORRESPONDENCE_STATE_KEY = "correspondenceState";
    public static final String CORRESPONDENCE_TYPE_OF_ADDRESS_KEY = "correspondenceTypeOfAddress";
    public static final String CORRESPONDENCE_GEOTAGGING_KEY = "correspondenceGeoTagging";

    public static final String NAME_OF_PROPERTY_KEY = "nameOfTheProperty";
    public static final String PROPERTY_ADDRESS_LINE_1_KEY = "propertyAddressLine1";
    public static final String PROPERTY_ADDRESS_LINE_2_KEY = "propertyAddressLine2";
    public static final String PROPERTY_LANDMARK_KEY = "propertyLandmark";
    public static final String PROPERTY_PIN_CODE_KEY = "propertyPINCode";
    public static final String PROPERTY_CITY_KEY = "propertyCity";
    public static final String PROPERTY_STATE_KEY = "propertyState";
    public static final String PROPERTY_GEOTAGGING_KEY = "propertyGeoTagging";

    public static final String TYPE_OF_PROFESSION_KEY = "typeOfProfession";

    public static final String SALARIED_NAME_OF_COMPANY_KEY = "nameOfTheCompany";
    public static final String SALARIED_YEARS_OF_EXPERIENCE_KEY = "yearsOfExperienceInCurrentCompany";
    public static final String SALARIED_TOTAL_WORK_EXPERIENCE_KEY = "totalWorkExperience";
    public static final String SALARIED_MONTHLY_INCOME_KEY = "monthlyIncome";
    public static final String SALARIED_DESIGNATION_KEY = "designation";
    public static final String SALARIED_ADDRESS_LINE_1_KEY = "salariedAddressLine1";
    public static final String SALARIED_ADDRESS_LINE_2_KEY = "salariedAddressLine2";
    public static final String SALARIED_LANDMARK_KEY = "salariedLandmark";
    public static final String SALARIED_PIN_CODE_KEY = "salariedPINCode";
    public static final String SALARIED_CITY_KEY = "salariedCity";
    public static final String SALARIED_STATE_KEY = "salariedState";
    public static final String SALARIED_GEOTAGGING_KEY = "salariedGeoTagging";
    public static final String SALARIED_SALARY_DATE_KEY = "salaryDate";

    public static final String TYPE_OF_BUSINESS_KEY = "typeOfBusiness";

    public static final String BUSINESS_TIN_KEY = "businessTIN";
    public static final String BUSINESS_NAME_KEY = "businessName";
    public static final String BUSINESS_ADDRESS_KEY = "BUSINESS_ADDRESS_KEY";
    public static final String INDUSTRY_TYPE_KEY = "industryType";
    public static final String ANNUAL_REVENUE_KEY = "annualRevenue";
    public static final String PROFIT_AFTER_TAXES_KEY = "profitAfterTaxes";
    public static final String PURPOSE_OF_LOAN_KEY = "purposeOfLoan";
    public static final String NO_OF_DIRECTORS_OR_PARTNERS_KEY = "noOfdirectorsOrPartners";
    public static final String PROFESSIONAL_GEOTAGGING_KEY = "professionalGeoTagging";
    public static final String BUSINESS_TIN_VERIFIED_KEY = "tinVerified";

    public static final String IDENTITY_PROOF_KEY = "identityProof";
    public static final String IDENTITY_PROOF_DOCUMENT_KEY = "identityProofDocument";
    public static final String ADDRESS_PROOF_KEY = "addressProof";
    public static final String ADDRESS_PROOF_DOCUMENT_KEY = "addressProofDocument";
    public static final String INCOME_PROOF_KEY = "incomeProof";
    public static final String INCOME_PROOF_DOCUMENT_KEY = "incomeProofDocument";
    public static final String EMPLOYMENT_PROOF_KEY = "employmentProof";
    public static final String EMPLOYMENT_PROOF_DOCUMENT_KEY = "employmentProofDocument";

    public static final String BUSINESS_ID_KEY = "idProofOfTheEnterprise";
    public static final String BUSINESS_ID_DOCUMENT_KEY = "businessIdProof";
    public static final String BUSINESS_FINANCE_KEY = "businessFinance";
    public static final String BUSINESS_FINANCE_DOCUMENT_KEY = "businessFinanceDocument";
    public static final String BUSINESS_BILL_KEY = "businessBill";
    public static final String BUSINESS_BILL_DOCUMENT_KEY = "businessBillsDocument";

    public static final String DRF_FORM_KEY = "drf";
    public static final String DRF_FORM_DOCUMENT_KEY = "drfFormDocument";
    public static final String CSF_FORM__KEY = "csf";
    public static final String CSF_FORM_DOCUMENT_KEY = "csfFormDocument";
    public static final String PDC_KEY = "pdc";
    public static final String PDC_DOCUMENT_KEY = "pdcDocument";
    public static final String INSURANCE_KEY = "insurance";
    public static final String INSURANCE_DOCUMENT_KEY = "insuranceDocument";
    public static final String NACH_KEY = "nach";
    public static final String NACH_DOCUMENT_KEY = "nachDocument";
    public static final String OTHERS_KEY = "others";
    public static final String OTHER_DOCUMENT_KEY = "otherDocument";

    public static final String COBORROWERS_PRESENT_KEY = "coBorrowerPresent";

    public static final String COBORROWERS_COUNT_KEY = "coBorrowersCount";

    public static final String COBORROWER_NAME_KEY = "nameOfCoBorrower";
    public static final String COBORROWER_PAN_KEY = "coBorrowersPAN";
    public static final String COBORROWER_AADHAAR_KEY = "coBorrowersAadhaar";
    public static final String COBORROWER_MOBILE_KEY = "coBorrowersMobile";
    public static final String COBORROWER_EMAILID_KEY = "coBorrowersEmailId";
    public static final String COBORROWER_ADDRESS_LINE_1_KEY = "coBorrowersAddressLine1";
    public static final String COBORROWER_ADDRESS_LINE_2_KEY = "coBorrowersAddressLine2";
    public static final String COBORROWER_LANDMARK_KEY = "coBorrowersLandmark";
    public static final String COBORROWER_CITY_KEY = "coBorrowersCity";
    public static final String COBORROWER_STATE_KEY = "coBorrowersState";
    public static final String COBORROWER_PIN_CODE_KEY = "coBorrowersPINCode";
    public static final String COBORROWERS_LIST_KEY = "coBorrowersList";

    public static final String BANK_STATEMENT_UPLOAD_KEY = "pdfUploadDump";
    public static final String AGGREGATOR_BANK_STATEMENT_UPLOAD_KEY = "aggPdfUploadDump";

    public static final String PERFIOS_VERIFIED_KEY = "perfiosVerified";
    public static final String PERFIOS_BANKING_SUMMARY_KEY = "perfiosBankingSummary";
    public static final String PERFIOS_TOTAL_CREDITS_KEY = "perfiosTotalCredits";
    public static final String PERFIOS_TOTAL_DEBITS_KEY = "perfiosTotalDebits";
    public static final String PERFIOS_TOTAL_BOUNCE_TRANSACTIONS_KEY = "perfiosTotalBounceTransactions";

    public static final String GUARANTOR_NAME_KEY = "nameOfGuarantor";
    public static final String GUARANTOR_PAN_KEY = "guarantorsPAN";
    public static final String GUARANTOR_AADHAAR_KEY = "guarantorsAadhaar";
    public static final String GUARANTOR_MOBILE_KEY = "guarantorsMobile";
    public static final String GUARANTOR_EMAILID_KEY = "guarantorsEmailId";
    public static final String GUARANTOR_ADDRESS_LINE_1_KEY = "guarantorsAddressLine1";
    public static final String GUARANTOR_ADDRESS_LINE_2_KEY = "guarantorsAddressLine2";
    public static final String GUARANTOR_LANDMARK_KEY = "guarantorsLandmark";
    public static final String GUARANTOR_CITY_KEY = "guarantorsPINCode";
    public static final String GUARANTOR_STATE_KEY = "guarantorsCity";
    public static final String GUARANTOR_PIN_CODE_KEY = "guarantorsState";

    public static final String PROCESSING_FEES_KEY = "processingFees";
    public static final String PROCESSING_FEES_MESSAGE_KEY = "processingFeesMessage";

    public static final String MODE_OF_PAYMENT_KEY = "modeOfPayment";
    public static final String CASH_COLLECTED_KEY = "cashCollected";
    public static final String INCLUDE_IN_LOAN_AMOUNT_KEY = "includeProcessingFeesInLoanAmount";
    public static final String CHEQUE_BANK_NAME_KEY = "nameOfBankOfCheque";
    public static final String CHEQUE_NUMBER_KEY = "chequeNumber";
    public static final String WALLET_SERVICE_PROVIDER_KEY = "serviceProvider";
    public static final String WALLET_MOBILE_NUMBER_KEY = "walletMobileNo";
    public static final String WALLET_TRANSACTION_ID_KEY = "walletTransactionId";

    public static final String CIBIL_VERIFIED_KEY = "cibilVerified";
    public static final String CIBIL_SCORE_KEY = "cibilScore";
    public static final String CIBIL_ACCOUNT_DETAILS_KEY = "cibilAccountDetails";
    public static final String CIBIL_ENQUIRIED_LAST_MONTH_KEY = "cibilEnquiriesLastMonth";

    public static final String REPAYMENT_BANK_NAME_KEY = "repaymentBankName";
    public static final String REPAYMENT_BANK_ACCOUNT_NUMBER_KEY = "repaymentBankAccountNumber";
    public static final String REPAYMENT_IFSC_CODE_KEY = "repaymentIFSCCode";
    public static final String REPAYMENT_BRANCH_NAME_KEY = "repaymentBranchName";
    public static final String REPAYMENT_BANK_CITY_KEY = "repaymentBankCity";
    public static final String REPAYMENT_BANK_STATE_KEY = "repaymentBankState";
    public static final String REPAYMENT_DATE_KEY = "repaymentDate";
    public static final String REPAYMENT_SCHEDULE_CREATED_STATUS_KEY = "repaymentScheduleCreatedStatus";

    public static final String FINACLE_LOAN_ACCOUNT_NUMBER_KEY = "finacleLoanAccountNumber";
    public static final String FINACLE_TRANSACTION_ID_KEY = "finacleTransactionId";
    public static final String FINACLE_LOAN_ACCOUNT_STATUS_KEY = "loanAccountCreationStatus";
    public static final String FINACLE_DISBURSEMENT_STATUS_KEY = "loanDisbursementStatus";
    public static final String DISBURSAL_DATE = "disbursalDate";
    public static final String DISBURSAL_CHANNEL = "disbursalChannel";

    public static final String CREDIT_ASSESSMENT_1_STATUS_KEY = "creditAssessment1Status";
    public static final String CREDIT_ASSESSMENT_2_STATUS_KEY = "creditAssessment2Status";
    public static final String CREDIT_ASSESSMENT_1_DECISION_KEY = "creditAssessment1Decision";
    public static final String CREDIT_ASSESSMENT_2_DECISION_KEY = "creditAssessment2Decision";

    public static final String CREDIT_ASSESSMENT_1_INPUT_KEY = "creditAssessment1Input";
    public static final String CREDIT_ASSESSMENT_1_OUTPUT_KEY = "creditAssessment1Output";
    public static final String CREDIT_ASSESSMENT_2_INPUT_KEY = "creditAssessment2Input";
    public static final String CREDIT_ASSESSMENT_2_OUTPUT_KEY = "creditAssessment2Output";
    public static final String FAILED_CE1_RESPONSE_KEY = "failedCE1AssessmentResult";
    public static final String FAILED_CE2_RESPONSE_KEY = "failedCE2AssessmentResult";

    public static final String CREDIT_ASSESSMENT_STATUS_KEY = "creditAssessmentStatus";
    public static final String CREDIT_ASSESSMENT_DECISION_KEY = "creditAssessmentDecision";

    public static final String CREDIT_ASSESSMENT_INPUT_KEY = "creditAssessmentInput";
    public static final String CREDIT_ASSESSMENT_OUTPUT_KEY = "creditAssessmentOutput";

    public static final String ASSESSMENT_DOCUMENT_KEY = "assessmentDocuments";

    public static final String SANCTION_ACCEPTANCE_STATUS_KEY = "sanctionAcceptanceStatus";
    public static final String GENERATED_SANCTION_LETTER_DOCUMENT_KEY = "generatedSanctionLetter";
    public static final String ACCEPTED_SANCTION_LETTER_DOCUMENT_KEY = "acceptedSanctionLetter";
    public static final String GENERATED_REPAYMENT_SCHEDULE_DOCUMENT_KEY = "generatedRepaymentSchedule";

    public static final String UPDATE_LEAD_STATUS_TASK_KEY = "updateLeadStatus";
    public static final String CO_BORROWERS_DETAILS_TASK_KEY = "coBorrowersDetails";
    public static final String NO_OF_COBORROWERS_TASK_KEY = "noOfCoBorrowers";
    public static final String CONGRATULATIONS_TASK_KEY = "congratulations-last";
    public static final String DISBURSE_LOAN_AMOUNT_TASK_KEY = "disburseLoanAmount";
    public static final String REPAYMENT_SCHEDULE_TASK_KEY = "repaymentSchedule";
    public static final String UNDERWRITER_DECISION_TASK_KEY = "underWriterDecision";
    public static final String CREDIT_OFFICER_TASK_KEY = "creditOfficerPortal";
    public static final String SANCTIONING_AUTHORITY_DECISION_TASK_KEY = "sanctioningAuthorityDecisionTask";
    public static final String UNDERWRITER_VERIFICATION_TASK_KEY = "validationVerification";
    public static final String PREDISBURSEMENT_DOCUMENT_CHECK_TASK_KEY = "preDisbursementDocumentsCheck";

    public static final String APPROVE_KEY = "approve";
    public static final String REJECT_KEY = "reject";
    public static final String RETRIGGER_KEY = "reTrigger";

    public static final String COMMENTS_KEY = "comment";
    public static final String FI_COMMENTS_KEY = "commentForFI";
    public static final String LEGAL_COMMENTS_KEY = "commentForLegal";
    public static final String VALUATION_COMMENTS_KEY = "commentForValuation";

    public static final String DECISION_KEY = "decision";
    public static final String CREDIT_OFFICER_DECISION_KEY = "caDecision";
    public static final String UNDER_WRITER_VERIFICATION_DECISION_KEY = "underWriterVerificationDecisionKey";
    public static final String UNDER_WRITER_DECISION_KEY = "underWriterDecision";
    public static final String SANCTION_DECISION_KEY = "sanctionDecision";

    public static final String RE_TRIGGER_FI_KEY = "reTriggerFI";
    public static final String RE_TRIGGER_LEGAL_KEY = "reTriggerLegal";
    public static final String RE_TRIGGER_VALUATION_KEY = "reTriggerValuation";

    public static final String PAN_MASTERS_KEY = "PAN";
    public static final String AADHAAR_MASTER_KEY = "Aadhaar";

    public static final String PAN_DETAILS_FILTER = "panDetailsFilter";
    public static final String LOAN_DETAILS_FILTER = "loanDetailsFilter";
    public static final String AADHAAR_DETAILS_FILTER = "aadhaarDetailsFilter";
    public static final String CORRESPONDENCE_ADDRESS_DETAILS_FILTER = "correspondenceAddressDetailsFilter";
    public static final String PROPERTY_DETAILS_FILTER = "propertyDetailsFilter";
    public static final String BUSINESS_DETAILS_FILTER = "businessDetailsFilter";

    public static final int SUCCESS_CODE = 200;
    public static final int FAILURE_CODE = 400;
    public static final int AUTHENTICATION_FAILURE_CODE = 401;
    public static final int INTERNAL_SERVER_ERROR_CODE = 500;
    public static final int INVALID_POST_REQUEST_DATA_ERROR_CODE = 422;

    public static final String STATUS_KEY = "status";
    public static final String MESSAGE_KEY = "message";
    public static final String BACK_TASK_LIST_KEY = "backTaskList";

    public static final String INTERNAL_SERVER_ERROR_MESSAGE = "Internal Server Error Occurred!!!";
    public static final String TASK_CONFIGURATION_INVALID_JSON_MESSAGE = "Error parsing task configuration JSON";
    public static final String BACK_TASK_LIST_NOT_AVAILABLE_MESSAGE = "Back task list not available.";
    public static final String BACK_TASK_LIST_NOT_ARRAY_MESSAGE = "Back task list not an array.";
    public static final String DATA_ERRORS_KEY = "error";
    public static final String INVALID_BACK_TASK_DEFINITION_KEY = "Invalid Back Task Definition Key";
    public static final String INVALID_USERNAME_PASSWORD = "Invalid Username Or Password";
    public static final String TOO_MANY_ROLES = "This User Has Too Many Roles Assigned";
    public static final String TOO_MANY_TASKS = "This User Has Too Many Tasks Assigned";
    public static final String NO_TASKS_MESSAGE = "This User Has No Tasks Assigned";
    public static final String NO_ROLES = "This User Has No Roles Assigned";

    public static final String INVALID_CLIENT_ID_MESSAGE = "Invalid Client ID";
    public static final String INVALID_JSON_CONFIG_MESSAGE = "Invalid JSON Config";
    public static final String AUTHENTICATION_FAILED_MESSAGE = "Authentication Failed";
    public static final String INVALID_PASSWORD_MESSAGE = "Invalid Password";
    public static final String INVALID_USER_ID_MESSAGE = "Invalid UserId";
    public static final String INVALID_USER = "Invalid User";
    public static final String APPLICATION_REOPEN_SUCCESS_MESSAGE = "Application Reopened Successfully";
    public static final String APPLICATION_CLAIM_SUCCESS_MESSAGE = "Application Claimed Successfully.";
    public static final String APPLICATION_REFER_SUCCESS_MESSAGE = "Application Referred Successfully.";
    public static final String APPLICATION_REJECT_SUCCESS_MESSAGE = "Application Rejected Successfully.";
    public static final String APPLICATION_APPROVE_SUCCESS_MESSAGE = "Application Approved Successfully.";
    public static final String APPLICATION_ONHOLD_SUCCESS_MESSAGE = "Application On Hold Successfully.";
    public static final String MISSING_USERNAME_PASSWORD = "Missing UserId or Password";
    public static final String INCORRECT_MOBILE_MESSAGE = "Incorrect Format For Mobile No.";
    public static final String INCORRECT_STATUS_MESSAGE = "Incorrect Status";
    public static final String MOBILE_MISSING_MESSAGE = "Mobile No. missing";
    public static final String INVALID_REFER_GROUP_MESSAGE = "Invalid Refer Group";
    public static final String INCORRECT_PIN_CODE = "Incorrect PIN Code";
    public static final String INCORRECT_IFSC_CODE = "Incorrect IFSC Code";
    public static final String SUCCESS_MESSAGE = "success";
    public static final String OK = "OK";
    public static final String USER_NOT_FOUND = "USER NOT FOUND";
    public static final String INCORRECT_OTP = "INCORRECT_OTP";
    public static final String INVALID_CREDENTIALS = "Invalid Credentials";
    public static final String NOT_FOUND = "NO DATA";
    public static final String BAD_REQUEST = "crmId required";

    public static final String UNPROCESSABLE_ENTITY = "NID REGISTERED WITH DIFFERENT MOBILE NUMBER";
    public static final String FAILURE_MESSAGE = "FAILURE!";
    public static final String FILE_UPLOAD_ERROR = "File is invalid or size of file exceeds limit";
    public static final String SOMETHING_WRONG_MESSAGE = "SOMETHING WENT WRONG!";
    public static final String INVALID_TASK_ID_MESSAGE = "INCORRECT TASK ID!";
    public static final String INVALID_PROCESS_INSTANCE_ID_MESSAGE = "INCORRECT PROCESS INSTANCE ID!";
    public static final String ASYNC_PERSONAL_CIBIL_TASK_NAME = "async_personal_cibil";
    public static final String ASYNC_PERFIOS_TASK_NAME = "async_perfios";
    public static final String PERFIOS_STMT_SUCCESSFUL = "4";
    public static final String PERFIOS_STMT_SUCCESSFUL_TEXT = "Perfios Processing Completed Successfully";
    public static final String PROCESS_DEFINITION_KEY = "happyJourney";
    public static final String PERSONAL_CIBIL_FIRING_FAILED = "ex021";

    public static final String LOAN_ACCOUNT_ALREADY_CREATED_MESSAGE = "Loan Account Already Created!!!";
    public static final String LOAN_ACCOUNT_NOT_CREATED_MESSAGE = "Loan Account Not Created!!!";
    public static final String LOAN_AMOUNT_ALREADY_DISBURSED_MESSAGE = "Loan Amount Already Disbursed!!!";
    public static final String COMMENT_REQUIRED_FOR_REJECTING_LOAN_APPLICATION_MESSAGE = "Comment is required for rejecting loan application.";
    public static final String REPAYMENT_SCHEDULE_NOT_CREATED_MESSAGE = "Repayment Schedule Not Created!!!";
    public static final String REPAYMENT_SCHEDULE_ALREADY_CREATED_MESSAGE = "Repayment Schedule Already Created!!!";
    public static final String LOAN_AMOUNT_NOT_DISBURSED_MESSAGE = "Loan Amount Not Disbursed!!!";
    public static final String INVALID_TASK_DEFINITION_KEY_MESSAGE = "Invalid Task Definition Key For Dashboard Processes";
    public static final String INVALID_DOCUMENT_TAG_MESSAGE = "Invalid Document Tag";
    public static final String COMMENT_REQUIRED_FOR_OVERRIDING_CE = "Comment is required if overriding credit engine!!!";
    public static final String ATLEAST_ONE_RETRIGGER_REQUIRED_MESSAGE = "Atleast One Re-Trigger required";
    public static final String COMMENT_REQUIRED_FOR_RETRIGGERING_MESSAGE = "Commment is mandatory For Re-Triggering ";
    public static final String INVALID_LOAN_APPLICATION_NUMBER_MESSAGE = "Invalid Loan Application Number!!!";
    public static final String APPLICATION_NOT_ASSIGNED_MESSAGE = "Application Not Assigned to this user.";
    public static final String APPLICATION_ALREADY_EXISTS_MESSAGE = "This application already exists";
    public static final String FINACLE_FAILURE_MESSAGE = "Finacle Invalid Response";
    public static final String INVALID_PROCESS_DEFINITION_KEY_MESSAGE = "Invalid Process Definition Key";
    public static final String DELETED_BY_DEV_MESSAGE = "Deleted By Dev";

    public static final String FI_IDENTITY_PROOF_KEY = "fiIdentityProof";
    public static final String FI_IDENTITY_PROOF_DOCUMENT_KEY = "fiIdentityProofDocument";
    public static final String FI_ADDRESS_PROOF_KEY = "fiAddressProof";
    public static final String FI_ADDRESS_PROOF_DOCUMENT_KEY = "fiAddressProofDocument";
    public static final String FI_INCOME_PROOF_KEY = "fiIncomeProof";
    public static final String FI_INCOME_PROOF_DOCUMENT_KEY = "fiIncomeProofDocument";
    public static final String FI_EMPLOYMENT_PROOF_KEY = "fiEmploymentProof";
    public static final String FI_EMPLOYMENT_PROOF_DOCUMENT_KEY = "fiEmploymentProofDocument";
    public static final String FI_EMANDATE_DOCUMENT_KEY = "fiUploadEMandate";
    public static final String FI_ADDITIONAL_DOCUMENT_KEY = "fiUploadAdditionalDocuments";
    public static final String FI_BORROWER_NAME_KEY = "fiBorrowersName";
    public static final String FI_BORROWER_AGE_KEY = "fiBorrowersAge";
    public static final String FI_QUALIFICATION_KEY = "fiQualification";
    public static final String FI_MARITAL_STATUS_KEY = "fiMaritalStatus";
    public static final String FI_PAN_KEY = "fiPAN";
    public static final String FI_PIN_CODE_KEY = "fiPINCode";
    public static final String FI_CITY_KEY = "fiCity";
    public static final String FI_AADHAAR_KEY = "fiAadhaar";
    public static final String FI_OWNERSHIP_OF_RESIDENCE_PREMISE_KEY = "fiOwnershipOfResidentialPremise";
    public static final String FI_ADDREESS_PROOF_ID_OR_SERIAL_NO_KEY = "fiAddressProofIdOrSerialNo";
    public static final String FI_LOCATION_TYPE_KEY = "fiLocationType";
    public static final String FI_GEOTAGGING_KEY_KEY = "fiGeoTagging";

    public static final String VALUATION_BORROWER_NAME_KEY = "valuationBorrowerName";
    public static final String VALUATION_ADDRESS_LINE_1_KEY = "valuationAddressLine1";
    public static final String VALUATION_ADDRESS_LINE_2_KEY = "valuationAddressLine2";
    public static final String VALUATION_PIN_CODE_KEY = "valuationPINCode";
    public static final String VALUATION_CITY_KEY = "valuationCity";
    public static final String VALUATION_STATE_KEY = "valuationState";
    public static final String VALUATION_TYPE_OF_PROPERTY_KEY = "valuationTypeOfproperty";
    public static final String VALUATION_AGE_OF_PROPERTY_KEY = "valuationAgeOfProperty";
    public static final String VALUATION_PROPERTY_VALUATION_KEY = "propertyValuation";
    public static final String VALUATION_LOCATION_TYPE_KEY = "valuationLocationType";
    public static final String VALUATION_GEOTAGGING_KEY = "valuationGeoTagging";
    public static final String VALUATION_UPLOAD_REPORT_KEY = "valuationUploadReport";

    public static final String LEGAL_BORROWER_NAME_KEY = "legalBorrowersName";
    public static final String LEGAL_ADDRESS_LINE_1_NAME_KEY = "legalAddressLine1";
    public static final String LEGAL_ADDRESS_LINE_2_NAME_KEY = "legalAddressLine2";
    public static final String LEGAL_PIN_CODE_KEY = "legalPINCode";
    public static final String LEGAL_CITY_KEY = "legalCity";
    public static final String LEGAL_STATE_KEY = "legalState";
    public static final String LEGAL_TYPE_OF_PROPERTY_KEY = "legalTypeOfProperty";
    public static final String LEGAL_AGE_OF_PROPERTY_KEY = "legalAgeOfProperty";
    public static final String LEGAL_OWNER_OF_PROPERTY_KEY = "legalOwnerOfProperty";
    public static final String LEGAL_RELATIONSHIP_WITH_BORROWER_KEY = "legalRelationshipWithBorrower";
    public static final String LEGAL_UPLOAD_REPORT_KEY = "legalUploadReport";

    public static final String APPROVE = "approve";
    public static final String AVAILABLE = "available";
    public static final String CLAIM = "claim";
    public static final String CALL_BACK = "callBack";
    public static final String REJECT = "reject";
    public static final String NEW = "new";
    public static final String INVALID_DEPLOYMENT_KEY_MESSAGE = "Invalid Deployment Key";
    public static final String NO_PROCESS_INSTANCE_FOR_MOBILE_MESSAGE = "No Process Instance For Given Mobile Number";
    public static final String NO_PROCESS_DEPLOYED_FOR_GIVEN_KEY_MESSAGE = "No Process Deployed For Given Key";
    public static final String NO_CASE_DEPLOYED_FOR_GIVEN_KEY_MESSAGE = "No Case Deployed For Given Key";

    public static final String DROP_LINK_MAIL_SUBJECT = "Hi!!! You Dropped Out. Need Help???";
    public static final String DROP_LINK_MAIL_BODY = "<p> Hi, <br><br> You dropped out of your loan journey. Need help? <br><br> Contact us at <strong>support@bank.com or +91 9809809800</strong></p>";

    public static final String TASK_NOT_DONE_FOR_PROC_INST = "Task Not Done For This Process Instance";
    public static final String NO_APPLICATION_ID_DATA_FOUND_MESSAGE = "No data for this application can be found!";

    public static final String LMS_MONTHLY_INSTALLMENT_KEY = "lmsMonthlyInstallment";
    public static final String LMS_REMAINING_TENURE_KEY = "lmsRemainingTenure";
    public static final String LMS_UPCOMING_PAYMENT_DATE_KEY = "lmsUpcomingPaymentDate";
    public static final String LMS_OUTSTANDING_AMOUNT_KEY = "lmsOutstandingAmount";
    public static final String LMS_TOTAL_OVERDUE_AMOUNT_KEY = "lmsTotalOverdueAmount";
    public static final String LMS_OVERDUE_AMOUNT_KEY = "lmsOverdueAmount";
    public static final String LMS_OVERDUE_FEE_AMOUNT_KEY = "lmsOverdueFee";
    public static final String LMS_NO_OF_MONTHS_OVERDUE_KEY = "lmsNoMonthsOverdue";
    public static final String LMS_PAYMENT_HISTORY_KEY = "lmsPaymentHistory";
    public static final String LMS_REPAYMENTS_KEY = "lmsRepayments";
    public static final String LMS_TOTAL_PAYMENT_AMOUNT_KEY = "lmsTotalPaymentAmount";


    // URL endpoints constants for modules
    public static final String CE_PROD_DEPLOYMENT_ENDPOINT = "/api/product/*/deploy";
    public static final String CE_PRODUCT_ENDPOINT = "/api/product";
    public static final String CE_PRODUCT_LIST_ENDPOINT = "/api/product/list**";
    public static final String CE_PRODUCT_ALL = "/api/product/**";
    public static final String CE_PRODUCT_TEST_ENDPOINT = "/api/test/**";
    public static final String CE_PRODUCT_LIST_ALL_ENDPOINT = "/api/product/list/**";
    public static final String CE_PRODUCT_CATEGORY_ENDPOINT = "/admin/product-category";

    public static final String CE_PRODUCT_CATEGORY_LIST_ENDPOINT = "/api/product/categories";
    public static final String CE_PRODUCT_FIRE_RULES_ENDPOINT = "/api/fire-rules/*";
    public static final String CE_PRODUCT_PUBLISH_ENDPOINT = "/api/product/*/publish";
    public static final String CE_PRODUCT_API_ENDPOINTS="/api/**";

    public static final String JOURNEY_LOGIN_ENDPOINT="/lending/journey/login**";
    public static final String JOURNEY_OTP_ENDPOINT="/otp/**";
    public static final String CONFIG_API_ENDPOINT="/api/config/**";
    public static final String JOURNEY_CUST_ENDPOINT="/lending/customer/**";
    public static final String JOURNEY_DEV_ENDPOINT="/lending/journey/dev/**";
    public static final String JOURNEY_INITIATE_ENDPOINTS="/lending/journey/**";
    public static final String COLLECTIONS_API_ENDPOINTS="/lending/collection/engine/**";

    // Constants for Workflow
    public static final String WF_MPIN_SET_ENDPOINT="/validate/set-mpin";
    public static final String WF_MPIN_VALIDATION_ENDPOINT="/validate/validate-mpin";
    public static final String WF_VALIDATION_ENDPOINT="/validate/**";
    public static final String WF_USER_DOCUMENT_ENDPOINT="/document/download";
    public static final String WF_DOCUMENT_PORTAL_DOWNLOAD_ENDPOINT="/document/portal-download";

    // Constants for roles
    public static final String CE_ADMIN_USER_ROLE = "ce_admin";
    public static final String CE_SUPERVISOR_USER_ROLE = "ce_supervisor";
    public static final String CE_MANAGER_USER_ROLE = "ce_manager";
    public static final String JR_DEFAULT_USER_ROLE="user";
    public static final String SALES_AGENT = "sales_agent";
    public static final String ESB_USER = "esb_user";

    // Actuator Constants
    public static final String ACTUATOR_ROLE = "ACTUATOR";

    public static final String AUTH = "Authorization";
    public static final String AUTH_TOKEN = "Authorization token";
    public static final String BEARER_TOKEN = "Bearer c7cf8b23077134dd7bbd8ef00caa1833438a5358";
    public static final Boolean PORTFOLIO_FLAG_VALUE = false;
    public static final String CASENAME = "caseName";
    public static final String APPLICATION_NUMBER = "applicationNumber";
    public static final String PORTFOLIO_FLAG = "portfolioFlag";
    public static final String SQL_ERROR = "Either SQL query is wrong or Database Connection Error " +
            "or please provide variable to save";
    public static final String PORTFOLIO_ID = "portfolioId";
    public static final String LOS_LMS_CONFIG_ENDPOINTS = "/lms-integration/**";

    public static final String BASE64_REGEX = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$";

    // Logging Constants
    public static final String LOG_EXCEPTION_USER_JOURNEY = "Exception raised for user {} journey {} is {}";
    public static final String LOG_EXCEPTION_USER_PROCESSINSTANCE = "Exception raised for user {} ProcessInstanceId {} is {}";
    public static final String LOG_START_METHOD ="Method {} started for process id {} for execution id {}";
    public static final String LOG_COMPLETE_METHOD ="Method {} completed for process id {} for execution id {}";

    //Journey Constants
    public enum SourceType {
        bpmn, cmmn;
    }

    public enum DeviceType {
        android, ios;
    }

}

