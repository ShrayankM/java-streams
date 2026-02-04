package org.example.gameEngine.api;

import org.example.gameEngine.boards.Board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class RuleSet implements Iterable<Rule> {
	private List<Rule> ruleList = new ArrayList<>();

	public void add(Rule rule) {
		ruleList.add(rule);
	}

	@Override
	public Iterator<Rule> iterator() {
		return ruleList.iterator();
	}

	@Override
	public void forEach(Consumer<? super Rule> action) {
		ruleList.forEach(action);
	}

	@Override
	public Spliterator<Rule> spliterator() {
		return ruleList.spliterator();
	}
}
