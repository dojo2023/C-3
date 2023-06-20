function checkNG(text)
{
  const NgWords = ["死ね","sine","しね","きえろ","消えろ","kiero","クロンボ","殺す","ころす","korosu","ちんば","つんぼ","部落","黒人","チョン","白人","ブサイク","不細工","ぶさいく"]; // ここにNGワードを追加していく
  for (let i = 0; i < NgWords.length; i++)
	{
    	if (text.includes(NgWords[i]))
		{
      		return true;
    	}
  	}
  return false;
}

function SubmitNGWords()
{
  const nicknameInput = document.getElementById("nickname");
  const messageInput = document.getElementById("message");

  // テキストエリアに入力された値を取得
  const nickname = nicknameInput.value;
  const message = messageInput.value;

  //NGワードのチェック
  	if (checkNG(nickname) || checkNG(message))
	{
      alert("※NGワードが含まれています※");
      return false;
	}
  return true;
}

setInterval(function()
{
  location.reload();
}, 1000);