package bean;

public class Message
{
    private int messageId;
    private String message;
    private String nickname;
    private int senderId;
    private int roomId;

    // コンストラクタ
    public Message()
    {
    }

    public String getNickname()
    {
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	// messageIdのゲッターとセッター
    public int getMessageId()
    {
        return messageId;
    }

    public void setMessageId(int messageId)
    {
        this.messageId = messageId;
    }

    // contentのゲッターとセッター
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    // senderIdのゲッターとセッター
    public int getSenderId()
    {
        return senderId;
    }

    public void setSenderId(int senderId)
    {
        this.senderId = senderId;
    }

    // roomIdのゲッターとセッター
    public int getRoomId()
    {
        return roomId;
    }

    public void setRoomId(int roomId)
    {
        this.roomId = roomId;
    }
}
