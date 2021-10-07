package wang.seamas.config;

import javax.sql.DataSource;

public class DataSourceManager {

    private static final ThreadLocal<DataTypes> dataTypes = ThreadLocal.withInitial(() -> DataTypes.MASTER );

    public static DataTypes get() {
        return DataSourceManager.dataTypes.get();
    }

    public static void set(DataTypes dataType) {
        DataSourceManager.dataTypes.set(dataType);
    }

    public static void reset() {
        DataSourceManager.dataTypes.set(DataTypes.MASTER);
    }
}
