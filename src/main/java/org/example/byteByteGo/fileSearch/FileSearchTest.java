package org.example.byteByteGo.fileSearch;

import java.util.List;

public class FileSearchTest {
	public static void main(String [] args) {
		final File root = new File("root", 100, "shrayank", FileType.DIRECTORY, true);
		final File a = new File("a", 10, "shrayank", FileType.TEXT, false);
		final File b = new File ("ab", 20, "shrayank", FileType.AUDIO, false);
		final File innerRoot = new File("innerRoot", 200, "shrayank", FileType.DIRECTORY, true);
		final File c = new File("c", 50, "shrayank", FileType.VIDEO, false);
		final File d = new File("d", 60, "shrayank", FileType.AUDIO, false);

		root.addFile(a);
		root.addFile(b);

		innerRoot.addFile(c);
		innerRoot.addFile(d);

		root.addFile(innerRoot);

//		EqualsOperator<Integer> integerEqualsOperator = new EqualsOperator<>();
//		GreaterThanOperator<Integer> greaterThanOperator = new GreaterThanOperator<>();
//		SimplePredicate<Integer> fileSizeCheck = new SimplePredicate<>(FileAttribute.SIZEINBYTES, greaterThanOperator, 9);
//		FileSearchCriteria fileSearchCriteria = new FileSearchCriteria(fileSizeCheck);

//		RegexOperator<String> regexOperator = new RegexOperator<>();
//		SimplePredicate<String> fileNameCheck = new SimplePredicate<>(FileAttribute.FILENAME, regexOperator, "ab");
//		FileSearchCriteria fileSearchCriteria = new FileSearchCriteria(fileNameCheck);

		EqualsOperator<FileType> fileTypeEqualsOperator = new EqualsOperator<>();
		RegexOperator<String> regexOperator = new RegexOperator<>();
		CompositePredicate compositePredicate = new AndPredicate(
				List.of(new SimplePredicate<>(FileAttribute.OWNER, regexOperator, "shra.*"),
						new SimplePredicate<>(FileAttribute.FILETYPE, fileTypeEqualsOperator, FileType.AUDIO))
		);

		FileSearchCriteria fileSearchCriteria = new FileSearchCriteria(compositePredicate);

		FileSearch fileSearch = new FileSearch();
		List<File> result = fileSearch.searchFiles(root, fileSearchCriteria);

		for (File file : result) {
			System.out.println(file);
		}
	}
}
