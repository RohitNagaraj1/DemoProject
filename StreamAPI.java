import java.util.ArrayList;
import java.util.List;

public class StreamAPI {
    class Model
    {
        String modelName;
        int carSpeed;

        public Model(String modelName, int speed)
        {
            this.modelName = modelName;
            this.carSpeed = speed;
        }

        public String getModelName()
        {
            return modelName;
        }

        public void setModelName(String modelName)
        {
            this.modelName = modelName;
        }

        public int getCarSpeed()
        {
            return carSpeed;
        }

        public void setCarSpeed(int carSpeed)
        {
            this.carSpeed = carSpeed;
        }

        public String toString()
        {
            return "";
        }
    }

    class Implementation
    {
        List<String> getModelName(List<Model> list)
        {
            return list.stream().map(i -> i.getModelName()).toList();
        }

        Model getModelInfo(List<Model> list, String model, int speed)
        {
            for (Model m : list)
            {
                if (m.getModelName().equals(model) && m.getCarSpeed()== speed)
                    return m;
            }

            return null;
        }
    }

    public static void main(String[] args) {
        List<Model> list =new ArrayList<>();
        StreamAPI s = new StreamAPI();
        list.add(s.new Model("SUV", 500));
        list.add(s.new Model("Sedan", 800));

        List<String> strs = s.new Implementation().getModelName(list);

        for (String str : strs)
            System.out.println(str);
    }
}
