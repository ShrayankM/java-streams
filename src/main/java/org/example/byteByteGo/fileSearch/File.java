package org.example.byteByteGo.fileSearch;

import java.util.HashSet;
import java.util.Set;

public class File {
	private final String filename;
	private final Integer sizeInBytes;
	private final String owner;
	private final FileType fileType;
	private final boolean isDirectory;
	private Set<File> entries;

	public File(String filename, Integer sizeInBytes, String owner, FileType fileType,
			boolean isDirectory) {
		this.filename = filename;
		this.sizeInBytes = sizeInBytes;
		this.owner = owner;
		this.fileType = fileType;
		this.isDirectory = isDirectory;

		if (isDirectory) {
			entries = new HashSet<>();
		}
	}

	public void addFile(File file) {
		if (isDirectory) {
			entries.add(file);
		} else {
			System.out.println("Cannot add file to type file, please add to directory");
		}
	}

	public Set<File> getEntries() { return entries; }
	public boolean isDirectory() { return isDirectory; }

	public Object extractFileAttribute(FileAttribute fileAttribute) {
		return switch (fileAttribute) {
			case FILENAME -> filename;
			case SIZEINBYTES -> sizeInBytes;
			case OWNER -> owner;
			case FILETYPE -> fileType;
			default -> throw new IllegalArgumentException("FileAttribute type not supported");
		};
	}

	@Override
	public String toString() {
		return filename + " | " + sizeInBytes + " bytes | " + owner + " | " + fileType;
	}
}
