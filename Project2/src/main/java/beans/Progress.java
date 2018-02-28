package beans;

import javax.persistence.*;

import beans.Tag;
@Entity
<<<<<<< HEAD
@Table(name = "PROGRESS")
=======
@Table
>>>>>>> 6da80ad7df5cf6ffceb735883e1c64acff6ceeb5
public class Progress {
	public Progress() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public Progress(int progressId, int total, int numCorrect, Tag tag, Users u) {
=======
	public Progress(int progressId, int total, int numCorrect, Tag tag) {
>>>>>>> 6da80ad7df5cf6ffceb735883e1c64acff6ceeb5
		super();
		this.progressId = progressId;
		this.total = total;
		this.numCorrect = numCorrect;
		this.tag = tag;
<<<<<<< HEAD
		this.user=u;
=======
>>>>>>> 6da80ad7df5cf6ffceb735883e1c64acff6ceeb5
	}

	//This is the PK value for the progress table and the sequence that generates it
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="progressSequence")
	@SequenceGenerator(allocationSize=1,name="progressSequence",sequenceName="SQ_PROGRESS_PK")
	@Column(name="PRORESS_ID")
	private int progressId;
	
	@Column
	private int total;
	
	@Column
	private int numCorrect;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TAG_ID")
	private Tag tag;
<<<<<<< HEAD
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "User_ID")
	private Users user;
=======
>>>>>>> 6da80ad7df5cf6ffceb735883e1c64acff6ceeb5

	public int getProgressId() {
		return progressId;
	}

	public void setProgressId(int progressId) {
		this.progressId = progressId;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNumCorrect() {
		return numCorrect;
	}

	public void setNumCorrect(int numCorrect) {
		this.numCorrect = numCorrect;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
}
