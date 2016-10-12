JDBC Teamplate 和 DAO 支持
一、JdbcTemplate 提供很多数据库操作方法，但其并不是一个orm工具，不支持级联属性
二、JdbcDaoSupport 可以通过设置数据源的方式，获取JdbcTemplate 来进行数据库操作，不如直接使用jdbcTemplate好。
三、NamedParameterJdbcTemplate 可具名的jdbcTemplate 可以给参数取名