package silvergecko.android.commons.async;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class TaskFragment extends Fragment {

	private Activity parentActivity;
	private Task mTask;
	
	public TaskFragment(Task task) {
		mTask = task;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setRetainInstance(true);
		
		mTask.execute();
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		parentActivity = activity;
		updateTaskCaller();
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		parentActivity = null;
		updateTaskCaller();
	}
	
	private void updateTaskCaller() {
		mTask.setCaller(parentActivity);
	}
	
}
