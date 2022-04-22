# simpleuserbatch2

Sprint Batch with Multiple data sources. It uses separate databases for batch meta-data and application tables.

Databases:
- batchmetadata - for batch meta-data tables
- simpleuserbatch2 - for app tables

Steps:

1. Provide 2 data sources in application.properties (For batch & app databases)
2. Define 2 data Sources with qualified names (DataSourceConfiguration.java) 
   - batchDataSource for batchmetadata database 
   - appDataSource for simpleuserbatch2 database
3. Annotate batchDataSource as @Primary
4. Use appDataSource in ItemWriter
   ```
   @Bean
   public JdbcBatchItemWriter<User> writer(@Qualifier("appDataSource") DataSource dataSource) {
   ```
5. Use batchDataSource in batch configuration
   ```
   @Bean
   BatchConfigurer batchConfigurer(@Qualifier("batchDataSource") DataSource dataSource){
   return new DefaultBatchConfigurer(dataSource);
   }
   ```