package lotto.controller;

import lotto.domain.*;
import lotto.domain.Number;
import lotto.view.Input;
import lotto.view.Output;

import java.util.Set;

public class LottoController {

    public static void main(String[] args) {
        Money inputMoney = Input.inputPrice();
        int manuallyPurchaseCount = Input.inputManuallyPurchaseCount();

        LottoShop lottoShop = new LottoShop(new RandomNumberStrategy(), inputMoney, manuallyPurchaseCount);
        Output.printManuallyLottoNumberRequest();
        while(lottoShop.possibleBuyManually()){
            lottoShop.buyManually(Input.inputLottoNumber());
        }
        Output.printBlank();

        Lottos lottos = lottoShop.buy();
        Output.printPurchasedLotto(lottos);

        Output.printWinnerNumbersRequest();
        Set<Number> winnerNumbers = Input.inputLottoNumber();
        Number bonusNumber = Input.inputBonusNumber();
        Output.printResult(lottos.getResult(new WinnerNumbers(winnerNumbers, bonusNumber)));
    }
}
