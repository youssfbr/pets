import { 
  HeaderContainer, 
  Logo
} from './Header.style';

export default function Header() {
  return (
    <HeaderContainer>
      <Logo src='/img/logo.svg' alt='Pet img' />
    </HeaderContainer>
  )
}