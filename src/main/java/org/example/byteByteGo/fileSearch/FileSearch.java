package org.example.byteByteGo.fileSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FileSearch {
	public List<File> searchFiles(File startingFile, FileSearchCriteria fileSearchCriteria) {
		List<File> result = new ArrayList<>();
		Queue<File> queue = new LinkedList<>();

		queue.add(startingFile);

		while (!queue.isEmpty()) {
			File f = queue.poll();

			if (fileSearchCriteria.isMatches(f)) {
				result.add(f);
			}

			if (f.isDirectory()) {
				Set<File> entries = f.getEntries();
				queue.addAll(entries);
			}
		}
		return result;
	}
}
