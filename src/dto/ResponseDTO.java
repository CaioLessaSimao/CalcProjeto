package dto;

public class ResponseDTO {

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    private int result = 0;

    public ResponseDTO(int result) {
        this.result = result;
    }



}
