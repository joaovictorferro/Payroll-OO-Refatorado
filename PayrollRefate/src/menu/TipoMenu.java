package menu;

public enum TipoMenu {
	Adiconar {
		@Override
		public Menu ObterMenu() {
			return new Adicionar();
		}
	},
	Remover {
		@Override
		public Menu ObterMenu() {
			return new Remover();
		}
	};
	
	public abstract Menu ObterMenu();
}
