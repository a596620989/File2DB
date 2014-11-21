package util;

public interface StoredProcedureName {
	// public static final String SECURITYMASTER_GETLISTPCSAS2 =
	// "BMW_SECURITYMASTER_PKG.getListPcsAs2";
	public static final String SECURITYMASTER_GETLISTPCSAS2 = "getListPcsAs2";
	public static final String SECURITYMASTER_DOLISTALL = "doListAll";
	public static final String SECURITYMASTER_GETLISTFIXEDINCOME = "getListFixedIncome";
	public static final String SECURITYMASTER_GETLISTCORPBOND = "getListCorpBond";
	public static final String SECURITYMASTER_GETLISTGOVBOND = "getListGovBond";

	// SecurityDailyDaoJdbc getListMtyEntries
	public static final String SECURITYDAILY_GETLISTDAILYHISTORY = "getListDailyHistory";
	public static final String SECURITYDAILY_DELETEDAILYHISTORY = "deleteDailyHistory";
	public static final String SECURITYDAILY_GETLISTMTYENTRIES = "getListMtyEntries";
	public static final String SECURITYDAILY_GETLISTDAILY = "getListDaily";

	// SecurityStageDaoJdbc
	public static final String SECURITYSTAGE_GETLISTNEWEQUITY = "getListNewEquity";
	public static final String SECURITYSTAGE_GETLISTNEWFIXEDINCOME = "getListNewFixedIncome";
	public static final String SECURITYSTAGE_GETLISTNEWSECURITIES = "getListNewSecurities";
	public static final String SECURITYSTAGE_GETLISTSECURITIES = "getListSecurities";
	public static final String SECURITYSTAGE_GETLISTEQUITY = "getListEquity";

	// StarsDaoJdbc
	public static final String STARS_BAD_GETLISTSECURITIES = "BAD_GETLISTSECURITIES";

	// IndicesMasterDaoJdbc
	public static final String INDICESMASTER_GETLISTINDICES = "getListIndices";
	public static final String INDICESMASTER_GETLISTCURRENCYINDICES = "getListCurrencyIndices";
	public static final String INDICESMASTER_GETLISTVOLATILITYINDICES = "getListVolatilityIndices";
	public static final String INDICESMASTER_GETLISTHISTORYENABLEDINDICES = "getListHistoryEnabledIndices";

	// IndicesDailyDaoJdbc
	public static final String INDICESMASTER_GETLISTDAILYHISTORY = "getListDailyHistory";
	public static final String INDICESMASTER_LISTDAILYHISTORY = "listDailyHistory";

	// SecurityValidateDaoJdbc, PACKAGE: BMW_SecurityValidate_PKG
	public static final String SecurityValidatePackage = "BMW_SecurityValidate_PKG";
	public static final String SecurityValidate_GetListEquity = "GET_LIST_EQUITY";
	public static final String SecurityValidate_GetListFixedIncome = "get_List_Fixed_income";
	public static final String SecurityValidate_GetListSecurities = "get_List_Securities";

	// IndicesValidateDaoJdbc, PACKAGE: BMW_SecurityValidate_PKG
	public static final String IndicesValidate_GetListIndices = "GET_LIST_INDICES";

	// SecuritiesDailyExceptionDaoJdbc, PACKAGE: BMW_SECURITY_DAILY_EXCEPTION
	public static final String SecuritiesDailyExpPackage = "BMW_SECURITY_DAILY_EXCEPTION";
	public static final String SecuritiesDailyExp_InsSecurityExp = "INSERT_SECURITY_EXCEPTIONS";
	public static final String SecuritiesDailyExp_InsSecurityExpList = "INSERT_SECURITY_EXP_LIST";
	public static final String SecuritiesDailyExp_ListSecurityExp = "LIST_SECURITY_EXCEPTION";
	public static final String SecuritiesDailyExp_DelDailyHistory = "delete_Daily_History";
	public static final String deleteDailyExceptions = "DELETE_DAILY_EXCEPTIONS";

	// SecurityExcpReportDaoJdbc, PACKAGE: BMW_SECURITY_EXCP_REPORT
	public static final String SecurityExcpReportPackage = "BMW_SECURITY_EXCP_REPORT";
	public static final String SecurityExcpReport_DailyReportPopulation = "DAILY_REPORT_POPULATION";
	public static final String SecurityExcpReport_DailyFiPriceRptPopulation = "daily_FiPrice_Rpt_Populate";
	public static final String SecurityExcpReport_DailyRptPortfolioPopulation = "DAILYRPT_PORTFOLIO_POPULATE";
	public static final String SecurityExcpReport_DummyRptPopulation = "dummy_Report_Population";

	// SecurityExposureDaoJDBC, PACKAGE: BMW_SecurityValidate_PKG
	public static final String SecurityValidate_ListDailyExposure = "list_Daily_Exposure";

	// JobConfig, PACKAGE: BMW_JOB_CONFIG_PKG
	public static final String JobConfigPackage = "BMW_JOB_CONFIG_PKG";
	public static final String JobConfig_GetBusinessDates = "GET_BUSINESS_DATES";
	public static final String JobConfig_GetPreviousDate = "GET_PREVIOUS_DATE";
	public static final String JobConfig_GetasOfDates = "GET_AsOfDate";
	public static final String JobConfig_IsInitialRunReadyStars = "Is_Initial_RunReady_STARS";
	public static final String JobConfig_IsInitialRunReadyPStars = "Is_Initial_RunReady_PSTARS";
	public static final String JobConfig_IsReRunReadyStars = "is_ReRun_Ready_STARS";
	public static final String JobConfig_IsReRunReadyPStars = "is_ReRun_Ready_PSTARS";
	// CheckpointDaoJdbc
	public static final String CheckpointDaoPackage = "BMW_CHECKPOIT_PKG";
	public static final String getCheckpoint = "getCheckpoint";
	public static final String getCheckpointbyCheckpointID = "getCheckpointbyCheckpointID";
	public static final String getCheckpointbyRunID = "getCheckpointbyRunID";
	public static final String getCheckpointbyDate = "getCheckpointbyDate";
	public static final String getCheckpointbyDateRange = "getCheckpointbyDateRange";
	public static final String updateCheckpoint = "updateCheckpoint";
	public static final String getNextCheckpointRunId = "getNextCheckpointRunId";
	public static final String getCheckpointbyJobIDAndDate = "getCheckpointbyJobIDAndDate";
	public static final String getCheckpointbyPendingState = "getCheckpointbyPendingState";
	// SecurityMasterHistoryDaoJdbc
	public static final String SecurityMasterHistoryPackage = "BMW_SECMASTERHISTORY_PKG";
	public static final String listHistory = "listHistory";
	public static final String updateHistory = "updateHistory";
	// AnalyzeJobJdbc
	public static final String AnalyzeJobJdbcPackage = "BMW_ANALYZEJOB_PKG";
	public static final String getAnalyzeJobInfo = "getAnalyzeJobInfo1";
	public static final String getAnalyzeJobInfo1 = "getAnalyzeJobInfo12";
	public static final String getAnalyzeJobLogId = "getAnalyzeJobLogId";
	public static final String bmwAnalyzeLog = "bmwAnalyzeLog";
	// F2DBInputStream
	public static final String F2DBInputStreamPackage = "BMW_FILETODB_PKG";
	public static final String INITDBINPUTSTREAM = "INITDBINPUTSTREAM";
	public static final String INITDBOUTSTREAM_UPDATE = "INITDBOUTSTREAM_UPDATE";
	public static final String INITDBOUTSTREAM_INSERT = "INITDBOUTSTREAM_INSERT";
	public static final String INITDBOUTSTREAM_GET = "INITDBOUTSTREAM_GET";
	public static final String INITDBOUTSTREAM_GET_COUNT = "INITDBOUTSTREAM_GET_COUNT";
}
