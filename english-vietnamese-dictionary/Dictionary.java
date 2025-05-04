import java.util.*;
import java.util.Map.Entry;

public class Dictionary {
	Map<String, String> dictionary = new HashMap<String, String>();

	public boolean isExisted(String name) {
		return this.dictionary.containsKey(name);
	}

	public boolean pushWord(String name, String meaning) {
		if (this.isExisted(name)) {
			return false;
		}
		this.dictionary.put(name, meaning);
		return true;

	}

	public boolean editWord(String name, String meaning) {
		if (!this.isExisted(name)) {
			return false;
		}
		this.dictionary.replace(name, meaning);
		return true;
	}

	public boolean deleteOneWord(String name) {
		if (!this.isExisted(name)) {
			return false;
		}
		this.dictionary.remove(name);
		return true;
	}

	public boolean clearAllWord() {
		this.dictionary.clear();
		return true;
	}

	public Set<Map.Entry<String, String>> getWordAll() {
		return this.dictionary.entrySet();
	}
	
	public String getValue(String name) {
		if (!this.isExisted(name)) {
			return null;
		}
		return this.dictionary.get(name);
	}
	public int getWordCount() {
		return this.dictionary.size();
	}
}
