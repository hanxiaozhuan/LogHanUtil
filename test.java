

public class test {

		String time;
		String classe;
		String username;
		String content;
		public test(String time,String classe,String username,String content){
			this.time=time;
			this.classe=classe;
			this.username=username;
			this.content=content;
		}
		@Override
		public String toString() {
			return this.time+"	"+this.username+"	"+this.classe+"	"+this.content+" \r\n";
		}
}
