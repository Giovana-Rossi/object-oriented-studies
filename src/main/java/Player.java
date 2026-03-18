public class Player {
    private String name;
    private int number;
    private String position;
    private boolean isFielded;


    public String getStateAsString()
    {
        return "Nome:" + name + "Número:" + number;
    }

    public boolean isFielded() {
        return isFielded;
    }


    public void setFielded(boolean fielded) {
        isFielded = fielded;
    }
}
