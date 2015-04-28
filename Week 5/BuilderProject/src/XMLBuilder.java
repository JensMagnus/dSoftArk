
public class XMLBuilder implements Builder {
	String result = "<document>\n";
	
	@Override
	public void buildSection(String text) {
		result += "<section name=\"" + text + "\">\n";
		
	}

	@Override
	public void buildSubsection(String text) {
		result += "<subsection name=\"" + text + "\">\n";
	}

	@Override
	public void buildParagraph(String text) {
		result += "<paragraph>\n" + text + "\n</paragraph>\n</subsection>\n";
	}

	public String getXML() {
		return result + "</section>\n</document>";
	}
}
