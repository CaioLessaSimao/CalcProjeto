package application;

import controller.ControllerCalc;
import dto.RequestDTO;
import dto.ResponseDTO;
import exception.OperacaoInvalidaException;
import view.Menu;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws OperacaoInvalidaException {

        Menu menu = new Menu();
        RequestDTO requestDTO = menu.show();
        ControllerCalc controllerCalc = new ControllerCalc();
        ResponseDTO responseDTO = controllerCalc.calc(requestDTO);
        menu.showResult(responseDTO);

    }
}
