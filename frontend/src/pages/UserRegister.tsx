import { useForm, SubmitHandler } from "react-hook-form"
import axios from "axios";

export default function UserRegister() {
    const {
        register,
        handleSubmit,
        watch,
        formState: { errors },
    } = useForm()

    type Inputs = {
        email: string
        password: string
        nickname: string
        name: string
    }

    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    const passwordRegex = /^(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/;
    const onSubmit: SubmitHandler<Inputs> = async (userData) => {
        const emailOk = await checkEmailDuplication(watch("email"));

        if(emailOk) {
            try {
                const response = await axios.post('/member/addMember', userData);
                alert('회원가입 완료');
            } catch (e) {
                alert('회원가입에 문제가 생겼어요.');
                console.error(e);
            }
        }
    }

    const checkEmailDuplication = async (email: string) => {
        try {
            const response = await axios.get(`/member/checkEmailDuplication?email=${email}`);
            if (response.status === 200) {
                return true
            }
        } catch (error) {
            if (error.response && error.response.status === 409) {
                alert('이미 사용 중인 이메일입니다.');
            } else {
                alert('이메일 확인 중 오류가 발생했습니다.');
            }
            return false;
        }
    };

    return (
        <>
            <h4>회원가입</h4>
            <p>비밀번호는 암호화되지 않고 저장되니 조심하세요.</p>
            {/* "handleSubmit" will validate your inputs before invoking "onSubmit" */}
            <form onSubmit={handleSubmit(onSubmit)}>
                {/* register your input into the hook by invoking the "register" function */}
                <label htmlFor="email">이메일</label>
                <input type="email" id="email" {...register("email", {required: true, maxLength: 40, pattern: emailRegex})} />
                <br/>
                {errors.email && <div>이메일 형식에 맞게 입력해주세요.</div>}
                {/* include validation with required or other standard HTML validation rules */}

                <label htmlFor="password">비밀번호</label>
                <input type="password" id="password" {...register("password", {required: true, minLength: 8, maxLength: 16, pattern: passwordRegex})} />
                <br/>
                {/* errors will return when field validation fails  */}
                {errors.password && <div>비밀번호를 8~16자의 특수문자를 포함한 문자열로 만들어주세요.</div>}

                <label htmlFor="nickname">닉네임</label>
                <input type="text" id="nickname" {...register("nickname", {required: true, minLength: 1, maxLength: 10})} />
                <br/>
                {errors.nickname && <div>닉네임을 1~10자로 지어주세요!</div>}

                <label htmlFor="name">이름</label>
                <input type="text" id="name" {...register("name", {required: true, minLength: 1, maxLength: 15})} />
                <br/>
                {errors.name && <div>이름을 1~15자로 입력해주세요!</div>}
                <button type="submit">회원가입</button>
            </form>
        </>
    )
}