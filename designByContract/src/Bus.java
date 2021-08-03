public class Bus {

        int totalPeopleCount;
        int speed;
        int seatNumber;
        int notSeatedPeopleCount;

        public Bus(int totalPeopleCount, int speed, int seatNumber,int notSeatedPeopleCount) {
            this.totalPeopleCount = totalPeopleCount;
            this.speed = speed;
            this.seatNumber = seatNumber;
            this.notSeatedPeopleCount = notSeatedPeopleCount;
        }

    public static void main(String[] args) {
       Bus bus = new Bus(70,70,20,15);
        //Bus bus = new Bus(105,70,20,15);
        //Bus bus = new Bus(80,120,20,15);
        //Bus bus = new Bus(80,70,9,15);
        //Bus bus = new Bus(80,70,40,15);
        //Bus bus = new Bus(70,70,20,74);
        System.out.println(bus.totalPeopleCount);

        assert bus.totalPeopleCount < 100 : "peopleCount cannot bigger than 100";
        assert bus.speed < 90 : "(speed) bus cannot be faster than 100 ";
        assert bus.seatNumber > 10 && bus.seatNumber < 30 : "seats cannot be less than 10 and bigger than 30";
        assert bus.notSeatedPeopleCount < 70 : "not seated passengers cannot be higher than 70";

    }
}
