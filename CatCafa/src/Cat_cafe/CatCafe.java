package Cat_cafe;

public interface CatCafe {
    void BuyinCat()throws InsufficientBalanceException;
    void TreatCus(Customer i);
    void CloseDown();
}
