package wang.seamas.service;


public interface TranService {

    int executeWithoutTransaction();

    int executeWithTransaction();
}
