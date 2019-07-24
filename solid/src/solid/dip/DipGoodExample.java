package solid.dip;

import java.util.List;

interface Developer {
	
	void develop(); 
}

class BackEndDeveloper implements Developer{
	
	@Override
	public void develop() {
		// write java code
	}
}

class FrontEndDeveloper implements Developer {

	@Override
	public void develop() {
		// write javascript code	
	}
}

class Project{
	private List<Developer> developers;
	
	Project(List<Developer> developers) {
		this.developers = developers;
	}
	
	void implement() {
		for(Developer developer:developers) {
			developer.develop();
		}
	}
}

public class DipGoodExample {

}
