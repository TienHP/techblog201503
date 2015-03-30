using UnityEngine;
using System.Collections;
using UnityEngine.UI;

public class HelloAndroid : MonoBehaviour {

	public InputField inputField;
	public Button sendButton;
	public Text text;
	private Animator animator;

#if UNITY_ANDROID
	AndroidJavaClass androidClass;
#endif

	// Use this for initialization
	void Start () {
#if UNITY_ANDROID
		AndroidJNI.AttachCurrentThread();
		androidClass = new AndroidJavaClass("com.example.hellounity.HelloUnity");
#endif
		sendButton.onClick.AddListener(()=>HandleSendButton());
		animator = GetComponent<Animator>();
	}

	private void HandleSendButton(){
		string text = inputField.text;
		//send it to device
#if UNITY_ANDROID
		string infor = androidClass.CallStatic<string>("getInforString", text);
		this.text.text = infor+": ";
#endif
	}

	// Update is called once per frame
	void Update () {
		
	}
}
