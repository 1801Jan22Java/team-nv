export interface Flashcard {
  flashcardId: number;
  question: string;
  answer: string;
	//groupLeader: string;
	hint: string;
	tag: {
		tagId: string,
		tagName: string
	}
}